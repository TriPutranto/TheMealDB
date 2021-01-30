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
    val thumb: String?
)