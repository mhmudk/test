package com.example.task.Details

import androidx.lifecycle.MutableLiveData
import com.example.task.Pojo.MovieDetails
import com.example.task.Retrof.Apis.ApiInterFace
import com.example.task.Retrof.Builder.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RepoDetails {


    fun getMoviebyId(movie: Int):MutableLiveData<MovieDetails> {
        var mutable=MutableLiveData<MovieDetails>()
        val interBuilder: ApiInterFace = Builder.retor.create(ApiInterFace::class.java)
        val call = interBuilder.getMovieDetails(movie)
        call.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                if(response.isSuccessful)
                    mutable.postValue(response.body())
            }
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {

            }

        })
        return mutable
    }

}