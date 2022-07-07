package com.example.task.Details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.task.Adapter.Adapter
import com.example.task.Const
import com.example.task.Pojo.Result
import com.example.task.databinding.ActivityMovieDetailsBinding

class Detials : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    var postion: Int? = null
    private val myAdapter by lazy { Adapter() }
    val movieDetalmodel = MovieDetailsViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catId = intent.getIntExtra("postion",78)
        movieDetalmodel.getMovied(catId).observe(this) {
            binding.titleDetails.text = it.title
            binding.descriptionDetails.text = it.overview
            Glide.with(applicationContext)
                .load(Const.BASE_URL_IMG + it.poster_path)
                .into(binding.imageViewDetails)
        }
    }
}