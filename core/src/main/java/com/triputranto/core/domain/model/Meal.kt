package com.triputranto.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
        val id: Int,
        val name: String?,
        val thumbnail: String?,
        val tags: String?,
        val youtube: String?,
        val ingredient1: String?,
        val ingredient2: String?,
        val ingredient3: String?,
        val ingredient4: String?,
        val ingredient5: String?,
        val measure1: String?,
        val measure2: String?,
        val measure3: String?,
        val measure4: String?,
        val measure5: String?,
) : Parcelable