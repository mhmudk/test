package com.example.task

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.task.Adapter.Adapter
import com.example.task.Pojo.Movie
import com.example.task.Repo.MovieViewModel
import com.example.task.Retrofit.ApiInterFace
import com.example.task.Retrofit.Builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val viewMoviemodel = MovieViewModel()
   // private val myAdapter: Adapter by lazy { Adapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

viewMoviemodel.getMoviesFromRemot().observe(this){
    for(x in it.results)
    Log.d("Data", x.title)
}
    }
}