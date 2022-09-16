package com.app.lerp.data.di.local

import android.content.Context
import androidx.room.Room
import com.app.lerp.data.local.AppDataBase
import com.app.lerp.data.local.room.dao.LoadPageMovieDao
import com.app.lerp.data.local.room.dao.MovieDao
import com.app.lerp.data.local.room.datasource.MovieRoom
import com.app.lerp.usecase.repository.movie.IMovieLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {
        synchronized(AppDataBase::class) {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, AppDataBase.APP_DATABASE_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }

    @Singleton
    @Provides
    fun provideMovieRoom(
         movieDao: MovieDao,
        loadPagemovieDao: LoadPageMovieDao
    ): IMovieLocalRepository {
        return MovieRoom(movieDao, loadPagemovieDao)
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: AppDataBase): MovieDao {
        return db.movieDao()
    }




    @Singleton
    @Provides
    fun provideLoadPageMovieDao(db: AppDataBase): LoadPageMovieDao {
        return db.loadPageMovieDao()
    }
}