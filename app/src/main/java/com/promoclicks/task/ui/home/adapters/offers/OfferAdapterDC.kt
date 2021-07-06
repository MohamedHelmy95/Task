package com.promoclicks.task.ui.home.adapters.offers

import androidx.recyclerview.widget.DiffUtil
import com.promoclicks.data.response.Slider

object OfferAdapterDC : DiffUtil.ItemCallback<Slider>() {
    override fun areItemsTheSame(
        oldItem: Slider,
        newItem: Slider
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: Slider,
        newItem: Slider
    ): Boolean = oldItem == newItem
}