package com.example.task.Pojo

data class Movie(
    var page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

data class Result(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val title: String,

)