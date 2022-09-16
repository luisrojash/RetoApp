package com.app.lerp.usecase.usecase

import android.util.Log
import com.app.lerp.core.model.EventResult
import com.app.lerp.entity.MovieData
import com.app.lerp.usecase.repository.movie.IMovieLocalRepository
import com.app.lerp.usecase.repository.movie.IMovieNetworkRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRemote: IMovieNetworkRepository
   // , private val movieLocal: IMovieLocalRepository,
)  {


    suspend fun getListMovie(page: Int): EventResult<List<MovieData>> {
        val result = movieRemote.getListMovie(page)
        /*if (result is EventResult.Success) {
            //deleteListInspectionLocal()
            insertInspection(result.value.listData)
        }*/
        return result
    }
}