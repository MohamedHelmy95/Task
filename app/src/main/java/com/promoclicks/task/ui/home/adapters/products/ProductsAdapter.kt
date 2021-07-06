package com.promoclicks.task.ui.home.adapters.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.promoclicks.data.response.HotProductPaidStatu
import com.promoclicks.task.databinding.HotdiscountItemHomeBinding


class ProductsAdapter(private val clickListener: ProductsClickListener) :
    ListAdapter<HotProductPaidStatu, ProductsAdapterViewHolder>(ProductsAdapterDC) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsAdapterViewHolder = ProductsAdapterViewHolder(

        binding = HotdiscountItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        clickListener = clickListener
    )


    override fun onBindViewHolder(holder: ProductsAdapterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)

    }


}