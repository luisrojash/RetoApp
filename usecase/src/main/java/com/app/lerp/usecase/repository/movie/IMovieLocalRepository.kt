package com.app.lerp.usecase.repository.movie

import com.app.lerp.entity.LoadPageMovieData
import com.app.lerp.entity.MovieData

interface IMovieLocalRepository {

    suspend fun deleteListMovieLocal()

    suspend fun insertMovieLocal(movie: MovieData)

    suspend fun insertListMovieLocal(listData: List<MovieData>)

    suspend fun deleteLoadPageMovieLocal()

    suspend fun insertLoadPageMovieLocal(loadPageMovieData: LoadPageMovieData)
}