package com.example.task.LoginRetrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getRetrofit(): Retrofit {
        var httpInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        var okHttpClient: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(httpInterceptor).build()
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://documenter.getpostman.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    fun getService():UsreService{
        var userServise: UsreService = getRetrofit().create(UsreService::class.java)
        return userServise
    }
}