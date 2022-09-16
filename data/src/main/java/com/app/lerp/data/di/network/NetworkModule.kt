package com.app.lerp.data.di.network

import com.app.lerp.data.network.movie.MovieApi
import com.app.lerp.data.network.movie.MovieNetwork
import com.app.lerp.usecase.repository.movie.IMovieNetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideMovieApi(@Named("baseUrl") retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
    @Provides
    fun provideMovieApiNetwork(api: MovieApi): IMovieNetworkRepository {
        return MovieNetwork(api)
    }
}