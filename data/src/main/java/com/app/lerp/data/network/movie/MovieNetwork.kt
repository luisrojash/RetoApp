package com.app.lerp.data.network.movie

import com.app.lerp.core.model.EventResult
import com.app.lerp.data.network.response.DataRetrofitResponse
import com.app.lerp.data.network.response.toEntity
import com.app.lerp.data.network.util.validateResponse
import com.app.lerp.entity.DataResponseMovie
import com.app.lerp.entity.MovieData
import com.app.lerp.usecase.repository.movie.IMovieNetworkRepository

class MovieNetwork(private val api: MovieApi) : IMovieNetworkRepository {

    override suspend fun getListMovie(page: Int): EventResult<DataResponseMovie> {
        return api.getMovie(page).validateResponse {
            this.toEntity()
        }
    }
}