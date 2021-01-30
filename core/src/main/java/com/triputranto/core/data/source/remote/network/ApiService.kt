package com.triputranto.core.data.source.remote.network

import com.triputranto.core.data.source.remote.response.RemoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): RemoteResponse

    @GET("lookup.php")
    suspend fun getMealById(@Query("i") id: Int): RemoteResponse
}