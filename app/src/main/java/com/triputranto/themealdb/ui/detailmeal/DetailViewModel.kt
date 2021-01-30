package com.triputranto.themealdb.ui.detailmeal

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.triputranto.core.domain.usecase.AppUseCase

class DetailViewModel @ViewModelInject constructor(private val appUseCase: AppUseCase?) :
    ViewModel() {
    fun getMealById(id: Int) = appUseCase?.getMealById(id)?.asLiveData()
}