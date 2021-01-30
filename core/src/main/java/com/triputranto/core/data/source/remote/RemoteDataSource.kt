package com.triputranto.core.data.source.remote

import com.triputranto.core.data.source.remote.network.ApiResponse
import com.triputranto.core.data.source.remote.network.ApiService
import com.triputranto.core.data.source.remote.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getMealsByCategory(category: String): Flow<ApiResponse<List<MealResponse>>> {
        return flow {
            try {
                val response = apiService.getMealsByCategory(category)
                val dataArray = response.meals
                if (dataArray?.isNotEmpty() ?: return@flow) {
                    emit(ApiResponse.Success(response.meals))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMealById(id: Int): Flow<ApiResponse<List<MealResponse>>> {
        return flow {
            try {
                val response = apiService.getMealById(id)
                val dataArray = response.meals
                if (dataArray?.isNotEmpty() ?: return@flow) {
                    emit(ApiResponse.Success(response.meals))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}