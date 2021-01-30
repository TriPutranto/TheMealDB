package com.triputranto.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.triputranto.core.BuildConfig.BASE_URL
import com.triputranto.core.data.source.AppRepositoryImpl
import com.triputranto.core.data.source.local.LocalDataSource
import com.triputranto.core.data.source.remote.RemoteDataSource
import com.triputranto.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService) =
        RemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideAppRepositoryImpl(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ) = AppRepositoryImpl(remoteDataSource, localDataSource)

}

