package com.triputranto.themealdb.ui.meals

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.triputranto.core.domain.usecase.AppUseCase

class MealsViewModel @ViewModelInject constructor(private val appUseCase: AppUseCase?) :
    ViewModel() {
    fun getMealByCategory(category: String) = appUseCase?.getFilterByCategory(category)?.asLiveData()
}