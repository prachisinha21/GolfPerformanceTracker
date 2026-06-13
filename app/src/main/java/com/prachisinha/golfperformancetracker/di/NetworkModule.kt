package com.prachisinha.golfperformancetracker.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.prachisinha.golfperformancetracker.data.remote.GolfApi
import com.prachisinha.golfperformancetracker.data.remote.adapters.SafeDoubleAdapter
import com.prachisinha.golfperformancetracker.data.remote.adapters.SafeIntAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://6a28d6b84e1e783349a60a88.mockapi.io/"

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Int::class.java, SafeIntAdapter())
            .registerTypeAdapter(Double::class.java, SafeDoubleAdapter())
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGolfApi(retrofit: Retrofit): GolfApi {
        return retrofit.create(GolfApi::class.java)
    }
}