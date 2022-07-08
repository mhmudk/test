package com.example.task.Details

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.MovieDetails

class MovieDetailsViewModel : ViewModel() {
fun getMovied(movie:Int):MutableLiveData<MovieDetails>{
    return RepoDetails.getMoviebyId(movie)
}


    }