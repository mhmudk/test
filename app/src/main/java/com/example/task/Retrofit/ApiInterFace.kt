package com.example.task.Retrofit

import com.example.task.Pojo.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterFace {

    @GET("movie/popular")
    fun getMove(
        @Query("api_key") apiKey: String = "87ff303a5be046799877856493b51a61"
    ): Call<Movie>




}