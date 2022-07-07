package com.example.task.LoginRetrofit

import com.example.task.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getRetrofit(): Retrofit {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        var okHttpClient: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(httpInterceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.LOGIN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    fun getService():UsreService{
        val userServise: UsreService = getRetrofit().create(UsreService::class.java)
        return userServise
    }
}