package com.example.task.Repo

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.Movie
import com.example.task.Retrofit.ApiInterFace
import com.example.task.Retrofit.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    val movieObj = RepoMovies()


    fun getMoviesFromRemot():MutableLiveData<Movie>{
     return    movieObj.getMovies()
    }


}