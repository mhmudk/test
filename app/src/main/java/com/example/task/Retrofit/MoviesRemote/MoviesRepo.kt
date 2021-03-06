package com.example.task.Retrofit.MoviesRemote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.task.Pojo.Movie
import com.example.task.Retrofit.Apis.ApiInterFace
import com.example.task.Retrofit.Builder.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepo : MovieInterface {

    override fun getMovies(): MutableLiveData<Movie> {
        val mutabl = MutableLiveData<Movie>()
        val interBuilder: ApiInterFace = Builder.retor.create(ApiInterFace::class.java)
        val call = interBuilder.getMove()
        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {

                    mutabl.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.d("Error", t.message.toString())

            }
        })
        return mutabl
    }


}