package com.triputranto.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @field:SerializedName("idMeal") val id: Int?,
    @field:SerializedName("strMeal") val name: String?,
    @field:SerializedName("strMealThumb") val thumbnail: String?,
    @field:SerializedName("strTags") val tags: String?,
    @field:SerializedName("strYoutube") val youtube: String?,
    @field:SerializedName("strIngredient1") val strIngredient1: String?,
    @field:SerializedName("strIngredient2") val strIngredient2: String?,
    @field:SerializedName("strIngredient3") val strIngredient3: String?,
    @field:SerializedName("strIngredient4") val strIngredient4: String?,
    @field:SerializedName("strIngredient5") val strIngredient5: String?,
    @field:SerializedName("strMeasure1") val strMeasure1: String?,
    @field:SerializedName("strMeasure2") val strMeasure2: String?,
    @field:SerializedName("strMeasure3") val strMeasure3: String?,
    @field:SerializedName("strMeasure4") val strMeasure4: String?,
    @field:SerializedName("strMeasure5") val strMeasure5: String?
)