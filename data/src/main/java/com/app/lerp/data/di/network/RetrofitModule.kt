package com.app.lerp.data.di.network

import android.content.Context
import com.app.lerp.core.ConstantsCore.Server
import com.app.lerp.data.BuildConfig
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun provideRetrofit(
        baseUrl: String,
        client: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        apiInterceptor: ApiInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Server.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Server.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Server.TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(apiInterceptor)
           // .sslSocketFactory(getSSLConfig(context)!!.socketFactory, getTrustManager()!!)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    this.level = when {
                        BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                        else -> HttpLoggingInterceptor.Level.NONE
                    }
                }
            )
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .build()
    }



}
