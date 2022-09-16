package com.app.lerp.entity


data class DataResponseMovie(
    val page: Int,
    val results: List<MovieData>,
    val totalPages: Int,
    val totalResult: Int
)

data class MovieData(
    var image: String,
    var title: String,
    var note: String,
    var date: String,
    var resume: String
)