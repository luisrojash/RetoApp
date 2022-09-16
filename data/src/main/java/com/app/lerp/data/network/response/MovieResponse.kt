package com.app.lerp.data.network.response

import com.app.lerp.entity.MovieData
import com.google.gson.annotations.SerializedName

data class DataRetrofitResponse(
    @SerializedName("pages")
    val paage: Int,
    @SerializedName("title")
    val results: List<MovieResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResult: Int
)


data class MovieResponse(
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val note: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("overview")
    val resume: String
)


fun MovieResponse.toEntity() = MovieData(
    image = "https://image.tmdb.org/t/p/w500" + image,
    title = title,
    note = note,
    date = date,
    resume = resume
)
