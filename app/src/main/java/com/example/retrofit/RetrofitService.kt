package com.example.retrofit

import com.example.url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint : Endpoint by lazy {
        Retrofit.Builder().baseUrl(url). addConverterFactory(
            GsonConverterFactory.create()). build().create(Endpoint::class.java)

    }
}