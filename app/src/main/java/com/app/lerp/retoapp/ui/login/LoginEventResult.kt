package com.app.lerp.retoapp.ui.login


sealed class LoginEventResult {
    object Loading : LoginEventResult()
    object Success : LoginEventResult()
    data class Error(val ex: Exception) : LoginEventResult()
}
