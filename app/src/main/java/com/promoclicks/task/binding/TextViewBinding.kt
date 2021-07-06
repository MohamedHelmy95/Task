package com.promoclicks.task.binding

import android.graphics.Paint
import android.widget.TextView

import androidx.databinding.BindingAdapter


@BindingAdapter("strikeThrough")
fun TextView.strikeThrough(strikeThrough: Boolean) {
    paintFlags = if (strikeThrough)
        paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    else
        paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}