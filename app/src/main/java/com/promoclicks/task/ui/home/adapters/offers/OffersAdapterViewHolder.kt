package com.promoclicks.task.ui.home.adapters.offers

import androidx.recyclerview.widget.RecyclerView
import com.promoclicks.data.response.Slider
import com.promoclicks.task.databinding.OfferItemHomeBinding


class OffersAdapterViewHolder(
    private val binding: OfferItemHomeBinding,
    private val clickListener: OffersPageListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Slider) {
        binding.item = item
        binding.offersPageListener = clickListener
        binding.executePendingBindings()

    }

}