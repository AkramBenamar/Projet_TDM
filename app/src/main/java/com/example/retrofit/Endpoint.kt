package com.example.retrofit







import com.example.entity.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface Endpoint {
    @POST("addmessage")
    fun addMessage(@Body message: mmg):Call<String>

    @POST("login")
   fun login(@Body login: login):Call<List<users>>


    @GET("getdoctors")
    fun getMedcins(): Call<List<Medecin>>

    @GET("getrdvs")
    fun getrdvs(): Call<List<rdv>>

    @POST("addrdv")
    fun addrdv(@Body rdv: rdv):Call<String>


    @POST("getrdv")
    fun getrdv(@Body patmed:patmed ):Call<List<rdv>>

    @POST("getmyrdvs")
    fun getmyrdvs(@Body patmed:patmed ):Call<List<infordv>>

    @POST("getagenda")
    fun getagenda(@Body patmed: patmed):Call<List<agenda>>

    @POST("getrdvsbydate")
    fun getrdvsbydate(@Body patmed:patmed ):Call<List<rdv>>

    @POST("getmytraitements")
    fun getmytraitements(@Body patmed:patmed ):Call<List<traitementsinfo>>
}