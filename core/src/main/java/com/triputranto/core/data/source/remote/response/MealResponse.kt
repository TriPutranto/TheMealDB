package com.triputranto.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @field:SerializedName("idMeal") val id: Int?,
    @field:SerializedName("strMeal") val name: String?,
    @field:SerializedName("strMealThumb") val thumbnail: String?
)