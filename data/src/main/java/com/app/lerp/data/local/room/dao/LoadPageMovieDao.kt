package com.app.lerp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.lerp.data.local.room.entity.LoadPageMovieDb

@Dao
interface LoadPageMovieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(loadPageMovie: LoadPageMovieDb)

    @Query("DELETE FROM load_page_movie ")
    suspend fun deleteListLocal()
}