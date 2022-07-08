package com.example.task.Retrof.MoviesRemote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.Movie
import com.example.task.Retrof.MoviesRemote.RepoMovies

class MovieViewModel : ViewModel() {

    val movieObj = RepoMovies()


    fun getMoviesFromRemot():MutableLiveData<Movie>{
     return    movieObj.getMovies()
    }


}