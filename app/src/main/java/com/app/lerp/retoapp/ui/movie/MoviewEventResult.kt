package com.app.lerp.retoapp.ui.movie

import com.app.lerp.entity.MovieData

sealed class MoviewEventResult {
    object Loading : MoviewEventResult()
    object NotLoading : MoviewEventResult()
    data class ShowListInspection(val listMovies: List<MovieData>) : MoviewEventResult()
    data class Error(val ex: Exception) : MoviewEventResult()
}