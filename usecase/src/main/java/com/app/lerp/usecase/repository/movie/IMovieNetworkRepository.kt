package com.app.lerp.usecase.repository.movie

import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.MovieData

interface IMovieNetworkRepository {

    suspend fun getListMovie(page: Int): EventResult<List<MovieData>>
}