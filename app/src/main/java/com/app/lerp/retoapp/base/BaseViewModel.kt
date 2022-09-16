package com.app.lerp.retoapp.base

import android.content.Context
import androidx.lifecycle.ViewModel
import com.app.lerp.core.extension.isConnected

abstract class BaseViewModel : ViewModel() {


    fun hasInternet(context: Context): Boolean {
        return context.isConnected()
    }
}