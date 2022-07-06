package com.example.task.Retrofit

import com.example.task.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Builder {

    val retor: Retrofit = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}