package com.app.lerp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.lerp.data.local.room.dao.LoadPageMovieDao
import com.app.lerp.data.local.room.dao.MovieDao
import com.app.lerp.data.local.room.entity.LoadPageMovieDb
import com.app.lerp.data.local.room.entity.MovieDb

@Database(
    version = 3,
    entities = [
        MovieDb::class,
        LoadPageMovieDb::class
    ]
)

abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val APP_DATABASE_NAME = "RetoAp.db"
    }

    abstract fun movieDao(): MovieDao
    abstract fun loadPageMovieDao(): LoadPageMovieDao
}