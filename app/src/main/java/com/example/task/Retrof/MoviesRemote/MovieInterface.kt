package com.example.task.Retrof.MoviesRemote

import androidx.lifecycle.MutableLiveData
import com.example.task.Pojo.Movie

interface MovieInterface {
    fun getMovies(): MutableLiveData<Movie>



}