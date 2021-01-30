package com.triputranto.core.domain.repository

import com.triputranto.core.data.Resource
import com.triputranto.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getMealsByCategory(category: String): Flow<Resource<List<Meal>>>
    fun getMealById(id: Int): Flow<Resource<List<Meal>>>
}