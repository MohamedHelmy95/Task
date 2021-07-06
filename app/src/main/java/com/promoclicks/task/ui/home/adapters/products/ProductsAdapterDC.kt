package com.promoclicks.task.ui.home.adapters.products

import androidx.recyclerview.widget.DiffUtil
import com.promoclicks.data.response.HotProductPaidStatu


object ProductsAdapterDC : DiffUtil.ItemCallback<HotProductPaidStatu>() {
    override fun areItemsTheSame(
        oldItem: HotProductPaidStatu,
        newItem: HotProductPaidStatu
    ): Boolean =
        oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: HotProductPaidStatu,
        newItem: HotProductPaidStatu
    ): Boolean = oldItem == newItem

}