package com.triputranto.core.domain.usecase

import com.triputranto.core.data.Resource
import com.triputranto.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getFilterByCategory(category: String): Flow<Resource<List<Meal>>>
    fun getMealById(id: Int): Flow<Resource<List<Meal>>>
}