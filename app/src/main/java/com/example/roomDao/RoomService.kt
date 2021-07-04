package com.example.roomDao
import androidx.room.Room
import android.content.Context

object RoomService {

    lateinit var context:Context

    val appDataBase: AppDataBase by lazy {
        Room.databaseBuilder(context, AppDataBase::class.java,"msgsdb").allowMainThreadQueries().build()
    }



}