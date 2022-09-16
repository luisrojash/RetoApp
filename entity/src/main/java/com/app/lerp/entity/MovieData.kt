package com.app.lerp.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class DataResponseMovie(
    val page: Int,
    val results: List<MovieData>,
    val totalPages: Int,
    val totalResult: Int
)

@Parcelize
data class MovieData(
    var image: String,
    var title: String,
    var note: String,
    var date: String,
    var resume: String
): Parcelable