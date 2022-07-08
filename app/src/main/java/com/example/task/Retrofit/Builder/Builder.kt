package com.example.task.Retrofit.Builder

import com.example.task.Pojo.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Builder {

    val retor: Retrofit = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}