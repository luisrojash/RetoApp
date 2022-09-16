package com.app.lerp.usecase.usecase

import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.DataResponseMovie
import com.app.lerp.entity.LoadPageMovieData
import com.app.lerp.entity.MovieData
import com.app.lerp.usecase.repository.movie.IMovieLocalRepository
import com.app.lerp.usecase.repository.movie.IMovieNetworkRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRemote: IMovieNetworkRepository,
    private val movieLocal: IMovieLocalRepository
)  {


    suspend fun getListMovie(page: Int): EventResult<DataResponseMovie> {
        val result = movieRemote.getListMovie(page)
        if (result is EventResult.Success) {
            deleteMovielist()
            deleteLoadPageMovie()
            insertListMovieLocal(result.value.results)
            insertEntityLoadPageMovieLocal(LoadPageMovieData(result.value.page,result.value.totalPages,result.value.totalResult))
        }
        return result
    }

    suspend fun insertEntityLoadPageMovieLocal(loadPageMovieData: LoadPageMovieData) {
        movieLocal.insertLoadPageMovieLocal(loadPageMovieData)
    }

    suspend fun deleteLoadPageMovie() {
        movieLocal.deleteListMovieLocal()
    }

    suspend fun insertListMovieLocal(listData: List<MovieData>) {

        movieLocal.insertListMovieLocal(listData)
    }


    suspend fun deleteMovielist() {
        movieLocal.deleteListMovieLocal()
    }
}