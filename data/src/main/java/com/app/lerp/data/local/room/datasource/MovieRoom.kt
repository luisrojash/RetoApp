package com.app.lerp.data.local.room.datasource

import android.util.Log
import com.app.lerp.data.local.room.dao.LoadPageMovieDao
import com.app.lerp.data.local.room.dao.MovieDao
import com.app.lerp.data.local.room.entity.toEntityData
import com.app.lerp.data.local.room.entity.toRoom
import com.app.lerp.entity.LoadPageMovieData
import com.app.lerp.entity.MovieData
import com.app.lerp.usecase.repository.movie.IMovieLocalRepository

class MovieRoom(
    private val movieDao: MovieDao,
    private val loadPagemovieDao: LoadPageMovieDao
) : IMovieLocalRepository {

    override suspend fun deleteListMovieLocal() {
        movieDao.deleteListLocal()
    }

    override suspend fun insertMovieLocal(movieData: MovieData) {
        movieDao.insert(movieData.toRoom())
    }

    override suspend fun insertListMovieLocal(listData: List<MovieData>) {
        Log.i("insertListMovieLocal  ", "" + listData.size)
        movieDao.insertList(listData.map { it.toRoom() }.toList())
    }

    override suspend fun deleteLoadPageMovieLocal() {
        loadPagemovieDao.deleteListLocal()
    }

    override suspend fun insertLoadPageMovieLocal(loadPageMovieData: LoadPageMovieData) {
        loadPagemovieDao.insert(loadPageMovieData.toRoom())
    }

    override suspend fun getListMovieLocal(page: Int, totalPages: Int):List<MovieData> {
        //page,totalPages
        return movieDao.getListMovieLocal().map { it.toEntityData() }
    }

    override suspend fun getLoadPageMovie(): LoadPageMovieData {
        val loadPageMovieDao = loadPagemovieDao.getLoadPageMovie()
        return LoadPageMovieData(
            loadPageMovieDao.page,
            loadPageMovieDao.totalPages,
            loadPageMovieDao.totalResult
        )
    }

}