package com.example.task.Repo

import com.example.task.Pojo.Movie
import com.example.task.Retrofit.ApiInterFace
import com.example.task.Retrofit.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoMovies : MovieInterface {

    lateinit var _response: Movie
    val response get() = _response
    override fun getMovies(): Movie {

        val interBuilder: ApiInterFace = Builder.retor.create(ApiInterFace::class.java)
        val call = interBuilder.getMove()
        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                _response = response.body()!!
                local.add
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }


        })
        return _response
    }
}