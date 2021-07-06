package com.promoclicks.task.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import me.relex.circleindicator.CircleIndicator2

@BindingAdapter("attachRecyclerViewIndicator", "attachAdapterIndicator", requireAll = false)
fun CircleIndicator2.bindCircleIndicator(
    recyclerView: RecyclerView?,
    adapter: ListAdapter<*, *>?
) {
    if (recyclerView == null) return
    val pagerSnapHelper = PagerSnapHelper().apply {
        recyclerView.onFlingListener = null
        attachToRecyclerView(recyclerView)
    }
    attachToRecyclerView(recyclerView, pagerSnapHelper)
    adapter?.registerAdapterDataObserver(this.adapterDataObserver)
}