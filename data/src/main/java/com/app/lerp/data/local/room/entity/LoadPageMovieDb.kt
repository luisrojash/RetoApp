package com.app.lerp.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.lerp.entity.LoadPageMovieData
import com.app.lerp.entity.MovieData


@Entity(tableName = "load_page_movie")
data class LoadPageMovieDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int = 1,
    @ColumnInfo(name = "page")
    var page: Int,
    @ColumnInfo(name = "total_pages")
    var totalPages: Int,
    @ColumnInfo(name = "total_results")
    var totalResult: Int,
)


fun LoadPageMovieData.toRoom()= LoadPageMovieDb(
    id = 1,
    page = page,
    totalPages = totalPages,
    totalResult = totalResult
)