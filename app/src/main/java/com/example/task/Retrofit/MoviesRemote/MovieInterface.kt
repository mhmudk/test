package com.example.task.Retrofit.MoviesRemote

import androidx.lifecycle.MutableLiveData
import com.example.task.Pojo.Movie

interface MovieInterface {
    fun getMovies(): MutableLiveData<Movie>


}