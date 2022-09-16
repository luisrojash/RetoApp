package com.app.lerp.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.lerp.entity.MovieData


@Entity(tableName = "movie")
data class MovieDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int?=null,
    @ColumnInfo(name = "image")
    var image: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "note")
    var note: String,
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "resume")
    var resume: String,
)

fun MovieData.toRoom() = MovieDb(
    image = image,
    title = title,
    note = note,
    date = date,
    resume = resume
)