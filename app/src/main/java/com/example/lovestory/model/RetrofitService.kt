package com.example.lovestory.model


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {
    val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getLoveApi(): LoveApi {
        return retrofit.create(LoveApi::class.java)
    }

    var api = retrofit.create(LoveApi::class.java)


}