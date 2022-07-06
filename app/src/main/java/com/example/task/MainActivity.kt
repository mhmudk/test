package com.example.task

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.task.Pojo.Movie
import com.example.task.Repo.MovieViewModel
import com.example.task.Retrofit.ApiInterFace
import com.example.task.Retrofit.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val viewMoviemodel = MovieViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewMoviemodel.getMovies()

        viewMoviemodel.mutabl.observe(this) {
            Log.d("Data", it.results[0].title)
        }

    }
}