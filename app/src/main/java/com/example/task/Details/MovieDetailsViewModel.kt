package com.example.task.Details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.Movie
import com.example.task.Retrofit.ApiInterFace
import com.example.task.Pojo.MovieDetails
import com.example.task.Retrofit.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsViewModel : ViewModel() {
var repoDetails = RepoDetails()
fun getMovied(movie:Int):MutableLiveData<MovieDetails>{
    return repoDetails.getMoviebyId(movie)
}
    /*
    fun getMoviebyId(movie: Int) {
        val interBuilder: ApiInterFace = Builder.retor.create(ApiInterFace::class.java)
        val call = interBuilder.getMovieDetails(movie)
        call.enqueue(object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                mutable.postValue(response.body())
            }
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {

            }

        })
    }

     */

    }