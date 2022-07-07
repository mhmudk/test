package com.example.task.Repo

import androidx.lifecycle.MutableLiveData
import com.example.task.Pojo.Movie

interface MovieInterface {
    fun getMovies(): MutableLiveData<Movie>



}