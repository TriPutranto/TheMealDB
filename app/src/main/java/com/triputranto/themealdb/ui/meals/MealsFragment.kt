package com.triputranto.themealdb.ui.meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.core.data.Resource
import com.triputranto.core.domain.model.Meal
import com.triputranto.themealdb.R
import com.triputranto.themealdb.databinding.FragmentMealsBinding
import com.triputranto.themealdb.utils.Const.KEY_ID
import com.triputranto.themealdb.utils.autoCleared
import com.triputranto.themealdb.utils.hide
import com.triputranto.themealdb.utils.observe
import com.triputranto.themealdb.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsFragment : Fragment(), MainAdapter.ItemListener {
    private var binding: FragmentMealsBinding by autoCleared()
    private val viewModel: MealsViewModel by viewModels()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()
    }

    private fun observeViewModel() {
        observe(viewModel.getMealByCategory("Beef"), ::handleMeals)
    }

    private fun initAdapter() {
        mainAdapter = MainAdapter(this)
        binding.mealsRv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mainAdapter
        }
    }

    private fun handleMeals(resource: Resource<List<Meal>>) {
        when (resource) {
            is Resource.Loading -> {
                binding.progressBar.show()
            }
            is Resource.Success -> {
                binding.progressBar.hide()
                resource.data?.let { mainAdapter.submitList(it) }
            }
            is Resource.Error -> {
                binding.progressBar.hide()
                Toast.makeText(requireContext(), resource.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onItemClicked(id: Int) {
        findNavController().navigate(
            R.id.action_charactersFragment_to_characterDetailFragment,
            bundleOf(KEY_ID to id)
        )
    }
}