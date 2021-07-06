package com.promoclicks.task.ui.home.adapters.products

import androidx.recyclerview.widget.RecyclerView
import com.promoclicks.data.response.HotProductPaidStatu
import com.promoclicks.task.databinding.HotdiscountItemHomeBinding


class ProductsAdapterViewHolder(
    private val binding: HotdiscountItemHomeBinding,
    private val clickListener: ProductsClickListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: HotProductPaidStatu, position: Int) {

        binding.item = item
        binding.productsClickListener = clickListener
        binding.position = position
        binding.executePendingBindings()


    }

}