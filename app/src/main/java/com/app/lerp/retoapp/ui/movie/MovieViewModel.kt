package com.app.lerp.retoapp.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.lerp.core.extension.launchOnIO
import com.app.lerp.retoapp.base.BaseViewModel
import com.app.lerp.usecase.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : BaseViewModel() {

    private val _movieLiveData: MutableLiveData<MoviewEventResult> = MutableLiveData()
    val movieLiveData: LiveData<MoviewEventResult> get() = _movieLiveData

    fun getListMovie(page: Int) {
        launchOnIO(
            doTask = {
                movieUseCase.getListMovie(page)
            },
            result = {
                // formatterPlaces(it, serviceCode)
                _movieLiveData.postValue(MoviewEventResult.ShowListInspection(it))
            },
            error = {
                _movieLiveData.postValue(MoviewEventResult.Error(it))
            }
        )
    }

}