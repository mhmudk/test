package com.example.task.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task.Pojo.Movie
import com.example.task.R

class Adapter(val context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var movieslist: List<Movie> = emptyList()

    fun setList(data: List<Movie>) {
        this.movieslist = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_movies, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
var img:ImageView = itemView.findViewById(R.id.img_movie)
var titel:TextView = itemView.findViewById(R.id.title_id)
var overView:TextView = itemView.findViewById(R.id.overview_id)
        fun setId(data:Movie){
            Glide.with().load(data.).into(imageView);
            titel.text= data.results.get().title
        }
    }

}