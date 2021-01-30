package com.triputranto.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idMeal: Int,
    val strMeal: String?,
    val strMealThumb: String?,
) : Parcelable