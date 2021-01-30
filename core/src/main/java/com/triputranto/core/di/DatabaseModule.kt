package com.triputranto.core.di

import android.content.Context
import com.triputranto.core.data.source.local.AppDao
import com.triputranto.core.data.source.local.AppDatabase
import com.triputranto.core.data.source.local.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        AppDatabase.getInstance(appContext)

    @Provides
    fun provideAppDao(appDatabase: AppDatabase) = appDatabase.appDao()

    @Singleton
    @Provides
    fun provideLocalDataSource(appDao: AppDao) = LocalDataSource(appDao)
}