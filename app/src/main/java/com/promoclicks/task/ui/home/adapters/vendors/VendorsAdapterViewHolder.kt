package com.promoclicks.task.ui.home.adapters.vendors

import androidx.recyclerview.widget.RecyclerView
import com.promoclicks.data.response.Vendor
import com.promoclicks.task.databinding.VendorsItemHomeBinding

class VendorsAdapterViewHolder(
    private val binding: VendorsItemHomeBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Vendor) {
        binding.item = item
        binding.executePendingBindings()

    }

}