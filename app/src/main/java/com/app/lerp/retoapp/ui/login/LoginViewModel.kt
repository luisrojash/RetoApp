package com.app.lerp.retoapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.lerp.core.extension.launchOnIO
import com.app.lerp.usecase.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {
    private val _signInLiveData: MutableLiveData<LoginEventResult> = MutableLiveData()
    val signInLiveData: LiveData<LoginEventResult> get() = _signInLiveData


    fun initUserSesion(usuario: String, clave: String) {
        launchOnIO(
            doTask = {
                userUseCase.initLogin(usuario,clave)
            },
            result = {
                _signInLiveData.value = LoginEventResult.Success
            },
            error = {
                _signInLiveData.value = LoginEventResult.Error(it)
            }
        )
    }


}