package com.app.lerp.retoapp.ui.movie

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.lerp.core.extension.launchOnIO
import com.app.lerp.retoapp.base.BaseViewModel
import com.app.lerp.usecase.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase,
    @ApplicationContext private val context: Context
) : BaseViewModel() {

    private val _movieLiveData: MutableLiveData<MoviewEventResult> = MutableLiveData()
    val movieLiveData: LiveData<MoviewEventResult> get() = _movieLiveData

    fun getListMovie(page: Int) {
        launchOnIO(
            doTask = {
                if (hasInternet(context)) {
                    movieUseCase.getListMovie(page)
                } else {
                    movieUseCase.getListMovieLocal(page)
                }
            },
            result = {
                _movieLiveData.postValue(MoviewEventResult.ShowListInspection(it))
            },
            error = {
                _movieLiveData.postValue(MoviewEventResult.Error(it))
            }
        )
    }

}