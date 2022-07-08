package com.example.task.Retrof.Builder

import com.example.task.LoginRetrofit.UsreService
import com.example.task.Pojo.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BuilderApiClient {

    fun getRetrofit(): Retrofit {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        var okHttpClient: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(httpInterceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Const.LAZY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit
    }
    fun getService(): UsreService {
        val userServise: UsreService = getRetrofit().create(UsreService::class.java)
        return userServise
    }
}