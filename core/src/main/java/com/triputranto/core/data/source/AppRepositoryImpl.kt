package com.triputranto.core.data.source

import com.triputranto.core.data.NetworkBoundResource
import com.triputranto.core.data.Resource
import com.triputranto.core.data.source.local.LocalDataSource
import com.triputranto.core.data.source.remote.RemoteDataSource
import com.triputranto.core.data.source.remote.network.ApiResponse
import com.triputranto.core.data.source.remote.response.MealResponse
import com.triputranto.core.domain.model.Meal
import com.triputranto.core.domain.repository.AppRepository
import com.triputranto.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : AppRepository {
    override fun getMealsByCategory(category: String): Flow<Resource<List<Meal>>> =
        object : NetworkBoundResource<List<Meal>, List<MealResponse>>() {
            override fun loadFromDB(): Flow<List<Meal>> = localDataSource.getAllMeals().map {
                DataMapper.mapEntitiesToDomain(it)
            }

            override fun shouldFetch(data: List<Meal>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MealResponse>>> =
                remoteDataSource.getMealsByCategory(category)

            override suspend fun saveCallResult(data: List<MealResponse>) {
                val meals = DataMapper.mapResponseToEntities(data)
                localDataSource.insertMeals(meals)
            }
        }.asFlow()

    override fun getMealById(id: Int): Flow<Resource<List<Meal>>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = remoteDataSource.getMealById(id).first()) {
            is ApiResponse.Success -> {
                val response = DataMapper.mapResponseToEntities(apiResponse.data)
                emit(Resource.Success(DataMapper.mapEntitiesToDomain(response)))
            }
            is ApiResponse.Empty -> {
                emit(Resource.Error<List<Meal>>("No result found"))
            }
            is ApiResponse.Error -> {
                emit(
                    Resource.Error<List<Meal>>(
                        apiResponse.errorMessage
                    )
                )
            }
        }
    }
}