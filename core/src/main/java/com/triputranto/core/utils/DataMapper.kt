package com.triputranto.core.utils

import com.triputranto.core.data.source.local.MealEntity
import com.triputranto.core.data.source.remote.response.MealResponse
import com.triputranto.core.domain.model.Meal

object DataMapper {

    fun mapResponseToEntities(input: List<MealResponse>): List<MealEntity> {
        val movieList = ArrayList<MealEntity>()
        input.map {
            val movie = MealEntity(
                id = it.id ?: 0,
                name = it.name,
                thumb = it.thumbnail,
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MealEntity>): List<Meal> =
        input.map {
            Meal(
                idMeal = it.id,
                strMeal = it.name,
                strMealThumb = it.thumb
            )
        }
}