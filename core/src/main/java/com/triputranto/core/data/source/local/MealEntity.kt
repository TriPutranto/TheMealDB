package com.triputranto.core.data.source.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_meal")
data class MealEntity(
    @PrimaryKey
    @NonNull
    var id: Int,
    var name: String?,
    val thumb: String?,
    val tags: String?,
    val youtube: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?
)