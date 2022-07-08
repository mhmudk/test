package com.example.task.Details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Pojo.MovieDetails

class MovieDetailsViewModel : ViewModel() {
    fun getMoviedByID(movie: Int): MutableLiveData<MovieDetails> {
        return DetailsRepo.getMoviebyId(movie)
    }


}