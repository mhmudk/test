package com.example.task.Retrofit.MoviesRemote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.Movie

class MovieViewModel : ViewModel() {

    val movieObj = RepoMovies()


    fun getMoviesFromRemot():MutableLiveData<Movie>{
     return    movieObj.getMovies()
    }


}