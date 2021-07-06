package com.promoclicks.task.di

import android.content.Context
import com.promoclicks.data.EndPoint
import com.promoclicks.data.EndPoint.CACHE_SIZE
import com.promoclicks.domain.BuildConfig.baseUrl

import com.promoclicks.domain.remote.interceptor.HeaderInterceptor

import com.promoclicks.task.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //Hilt Provide Network Cache
    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, CACHE_SIZE)

    //
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }
    }


    //
    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        headerInterceptor: HeaderInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {

            connectTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            readTimeout(EndPoint.timeOut, TimeUnit.SECONDS)
            writeTimeout(EndPoint.timeOut, TimeUnit.SECONDS)

            addInterceptor(headerInterceptor)

            addInterceptor(loggingInterceptor)

            cache(cache)

        }.build()

    }

    //
    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    //
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
    }


}
