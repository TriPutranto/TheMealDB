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
                    tags = it.tags,
                    youtube = it.youtube,
                    strIngredient1 = it.strIngredient1,
                    strIngredient2 = it.strIngredient2,
                    strIngredient3= it.strIngredient3,
                    strIngredient4 = it.strIngredient4,
                    strIngredient5 = it.strIngredient5,
                    strMeasure1 = it.strMeasure1,
                    strMeasure2 = it.strMeasure2,
                    strMeasure3 = it.strMeasure3,
                    strMeasure4 = it.strMeasure4,
                    strMeasure5 = it.strMeasure5
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MealEntity>): List<Meal> =
            input.map {
                Meal(
                        id = it.id,
                        name = it.name,
                        thumbnail = it.thumb,
                        tags = it.tags,
                        youtube = it.youtube,
                        ingredient1 = it.strIngredient1,
                        ingredient2 = it.strIngredient2,
                        ingredient3 = it.strIngredient3,
                        ingredient4 = it.strIngredient4,
                        ingredient5 = it.strIngredient5,
                        measure1 = it.strMeasure1,
                        measure2 = it.strMeasure2,
                        measure3 = it.strMeasure3,
                        measure4 = it.strMeasure4,
                        measure5 = it.strMeasure5
                )
            }
}