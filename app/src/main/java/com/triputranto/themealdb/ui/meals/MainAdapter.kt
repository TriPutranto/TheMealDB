package com.triputranto.themealdb.ui.meals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.triputranto.core.domain.model.Meal
import com.triputranto.themealdb.databinding.ItemMealBinding
import com.triputranto.themealdb.utils.load

class MainAdapter(private val listener: ItemListener):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    interface ItemListener {
        fun onItemClicked(id: Int)
    }

    private var meals = ArrayList<Meal>()

    fun submitList(list: List<Meal>) {
        meals.clear()
        this.meals.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    override fun getItemCount(): Int = meals.size

    class ViewHolder(private val binding: ItemMealBinding, private val listener: ItemListener) : RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal) {
            with(binding) {
                tvName.text = meal.strMeal
                ivThumb.load(meal.strMealThumb)
                root.setOnClickListener { listener.onItemClicked(meal.idMeal) }
            }
        }
    }
}