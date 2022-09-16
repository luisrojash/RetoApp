package com.app.lerp.data.di.network


import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiInterceptor @Inject constructor() : Interceptor {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            // .addHeader("Authorization", "Bearer ${token?.token?.trim()}")
            .build()
        return chain.proceed(request)
    }
}