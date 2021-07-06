package com.promoclicks.task.ui.home.adapters.sponsors

import androidx.recyclerview.widget.DiffUtil
import com.promoclicks.data.response.Sponsor

object SponsorsAdapterDC : DiffUtil.ItemCallback<Sponsor>() {
    override fun areItemsTheSame(
        oldItem: Sponsor,
        newItem: Sponsor
    ): Boolean = oldItem.image == newItem.image


    override fun areContentsTheSame(
        oldItem: Sponsor,
        newItem: Sponsor
    ): Boolean = oldItem == newItem

}