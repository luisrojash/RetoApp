package com.app.lerp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.lerp.data.local.room.entity.MovieDb

@Dao
interface MovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(moviedb: MovieDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(listMovie: List<MovieDb>)

    @Query("DELETE FROM movie ")
    suspend fun deleteListLocal()

    @Query("SELECT * FROM movie ")//LIMIT 5 OFFSET:totalPages
    suspend fun getListMovieLocal(): List<MovieDb>
}