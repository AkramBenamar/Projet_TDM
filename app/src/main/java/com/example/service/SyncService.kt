package com.example.service


import android.annotation.SuppressLint
import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.retrofit.RetrofitService
import com.example.entity.mmg
import com.example.roomDao.RoomService

import com.google.common.util.concurrent.ListenableFuture

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("RestrictedApi")
class SyncService(val ctx: Context, val workParamters: WorkerParameters):ListenableWorker(ctx, workParamters){

    lateinit var  future:SettableFuture<Result>



    override fun startWork(): ListenableFuture<Result> {

        future = SettableFuture.create()
        val msg = RoomService.appDataBase.getMsgDao().getMessagesToSynchronize()
        addMessages(msg)
        return future
    }





    fun addMessages(message: mmg) {
        val result = RetrofitService.endpoint.addMessage(message)
        result.enqueue(object: Callback<String> {

            override fun onFailure(call: Call<String>?, t: Throwable?) {

                future.set(Result.retry())


            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {

                if(response?.isSuccessful!!) {
                   // for (m in message) {
                        message.isSynchronized = 1
                    //}
                    RoomService.appDataBase.getMsgDao().updateMessage(message)
                    future.set(Result.success())

                }
                else
                {
                    future.set(Result.retry())
                }
            }

        })
    }


}
