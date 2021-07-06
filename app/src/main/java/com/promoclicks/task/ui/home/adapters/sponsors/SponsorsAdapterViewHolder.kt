package com.promoclicks.task.ui.home.adapters.sponsors

import androidx.recyclerview.widget.RecyclerView
import com.promoclicks.data.response.Sponsor
import com.promoclicks.task.databinding.SponserItemHomeBinding

class SponsorsAdapterViewHolder(
    private val binding: SponserItemHomeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Sponsor) {
        binding.item = item
        binding.executePendingBindings()
    }

}