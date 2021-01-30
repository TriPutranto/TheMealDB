package com.triputranto.core.di

import com.triputranto.core.data.source.AppRepositoryImpl
import com.triputranto.core.domain.repository.AppRepository
import com.triputranto.core.domain.usecase.AppInteractor
import com.triputranto.core.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Suppress("unused")
    @Binds
    abstract fun bindAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

    @Suppress("unused")
    @Binds
    abstract fun bindAppUseCase(appInteractor: AppInteractor): AppUseCase

}