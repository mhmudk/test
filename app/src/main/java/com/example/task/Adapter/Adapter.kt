package com.example.task.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task.Const
import com.example.task.Pojo.Result
import com.example.task.Pojo.Movie
import com.example.task.R

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
    var movieslist: List<Result> = emptyList()

    fun setList(data: List<Result>) {
        this.movieslist = data
        notifyDataSetChanged()
    }

    interface SentDetails {
        fun onItemClick(postion: Int  )
    }

    fun setOnItemClick(item: SentDetails) {
        this.onItemListner = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_movies, parent, false)
        return ViewHolder(view, onItemListner)
    }
    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data: Result = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    inner class ViewHolder(itemView: View, itemlistner: SentDetails) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.img_movie)
        var titel: TextView = itemView.findViewById(R.id.title_id)
        var overView: TextView = itemView.findViewById(R.id.overview_id)

        init {
            itemView.setOnClickListener {
                onItemListner.onItemClick(movieslist[layoutPosition].id)
            }

        }


        fun setId(data: Result) {
            titel.text = data.title
            overView.text = data.overview
            Glide.with(img.context)
                .load(Const.BASE_URL_IMG + data.poster_path)
                .into(img)
        }


    }

}