package com.triputranto.core.domain.usecase

import com.triputranto.core.data.Resource
import com.triputranto.core.domain.model.Meal
import com.triputranto.core.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInteractor @Inject constructor(private val appRepository: AppRepository) : AppUseCase {
    override fun getFilterByCategory(category: String): Flow<Resource<List<Meal>>> =
        appRepository.getMealsByCategory(category)

    override fun getMealById(id: Int): Flow<Resource<List<Meal>>> = appRepository.getMealById(id)
}