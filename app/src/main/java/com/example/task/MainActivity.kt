package com.example.task

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.task.Adapter.Adapter
import com.example.task.Details.Detials
import com.example.task.Pojo.Result
import com.example.task.Retrofit.MoviesRemote.MovieViewModel

import com.example.task.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewMoviemodel = MovieViewModel()
    private val myAdapter by lazy { Adapter() }
    var pressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewMoviemodel.getMoviesFromRemot().observe(this) {
            sentDataToAdapter(it.results)
        }
        myAdapter.setOnItemClick(object : Adapter.SentDetails {

            override fun onItemClick(posti: Int) {
                val intent = Intent(applicationContext, Detials::class.java)
                intent.putExtra("postion", posti)
                startActivity(intent)
            }

        })
    }

    fun sentDataToAdapter(listmovie: List<Result>) {
        myAdapter.setList(listmovie)
        binding.recMain.adapter = myAdapter
    }
    override fun onBackPressed() {
        if(pressed){
            super.onBackPressed();
        }
        else{
            return;
        }
    }


}