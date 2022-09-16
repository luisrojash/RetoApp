package com.app.lerp.data.network.movie

import com.app.lerp.data.BuildConfig
import com.app.lerp.data.network.response.DataRetrofitResponse
import com.app.lerp.data.network.response.MovieResponse
import com.app.lerp.data.network.util.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {


    @GET("upcoming")
    suspend fun getMovie(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<DataRetrofitResponse>
}