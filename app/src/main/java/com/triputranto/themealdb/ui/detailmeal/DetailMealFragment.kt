package com.triputranto.themealdb.ui.detailmeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.triputranto.core.data.Resource
import com.triputranto.core.domain.model.Meal
import com.triputranto.themealdb.databinding.FragmentDetailMealBinding
import com.triputranto.themealdb.utils.*
import com.triputranto.themealdb.utils.Const.KEY_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMealFragment : Fragment() {
    private val viewModel: DetailViewModel by viewModels()
    private var binding: FragmentDetailMealBinding by autoCleared()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(KEY_ID)?.let {
            observeViewModel(it)
        }
    }

    private fun observeViewModel(id: Int) {
        observe(viewModel.getMealById(id), ::handleDetail)
    }

    private fun handleDetail(resource: Resource<List<Meal>>) {
        when (resource) {
            is Resource.Loading -> {
                binding.progressBar.show()
            }
            is Resource.Success -> {
                binding.progressBar.hide()
                setupUI(resource.data?.get(0))
            }
            is Resource.Error -> {
                binding.progressBar.hide()
                Toast.makeText(requireContext(), resource.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun setupUI(meal: Meal?) {
        with(binding) {
            if (meal != null) {
                ivThumb.load(meal.thumbnail)
                tvName.text = meal.name
                tvTags.text = meal.tags
                tvYoutube.text = meal.youtube

                tvIngredient1.text = meal.ingredient1
                tvIngredient2.text = meal.ingredient2
                tvIngredient3.text = meal.ingredient3
                tvIngredient4.text = meal.ingredient4
                tvIngredient5.text = meal.ingredient5

                tvMeasure1.text = meal.measure1
                tvMeasure2.text = meal.measure2
                tvMeasure3.text = meal.measure3
                tvMeasure4.text = meal.measure4
                tvMeasure5.text = meal.measure5
            }
        }
    }
}