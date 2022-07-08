package com.example.task.Retrof.MoviesRemote

import androidx.lifecycle.MutableLiveData
import com.example.task.Pojo.Movie
import com.example.task.Retrof.Apis.ApiInterFace
import com.example.task.Retrof.Builder.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoMovies : MovieInterface {

    override fun getMovies():MutableLiveData<Movie> {
        val mutabl = MutableLiveData<Movie>()
        val interBuilder: ApiInterFace = Builder.retor.create(ApiInterFace::class.java)
        val call = interBuilder.getMove()
        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
      if(response.isSuccessful){

          mutabl.postValue(response.body())
      }
            }
            override fun onFailure(call: Call<Movie>, t: Throwable) {

            }
        })
        return mutabl
    }


}