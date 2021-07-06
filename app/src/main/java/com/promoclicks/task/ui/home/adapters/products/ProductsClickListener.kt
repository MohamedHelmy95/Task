package com.promoclicks.task.ui.home.adapters.products

import android.view.View
import com.promoclicks.data.response.HotProductPaidStatu

interface ProductsClickListener {
    fun onFabClick(view: View, item: HotProductPaidStatu, position: Int)
    fun onItemClick(view: View, item: HotProductPaidStatu)

}