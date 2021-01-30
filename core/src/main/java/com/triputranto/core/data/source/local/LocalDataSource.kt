package com.triputranto.core.data.source.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val appDao: AppDao) {
    fun getAllMeals(): Flow<List<MealEntity>> = appDao.getAllMeals()
    suspend fun insertMeals(meals: List<MealEntity>) = appDao.insertMeals(meals)
}