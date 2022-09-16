package com.app.lerp.retoapp.ui.movie

import com.app.lerp.entity.DataResponseMovie

sealed class MoviewEventResult {
    object Loading : MoviewEventResult()
    object NotLoading : MoviewEventResult()
    data class ShowListInspection(val data: DataResponseMovie) : MoviewEventResult()
    data class Error(val ex: Exception) : MoviewEventResult()
}