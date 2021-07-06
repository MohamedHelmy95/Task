package com.promoclicks.task.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.promoclicks.task.R

@BindingAdapter("bindSwipeRefreshLayoutColor")
fun SwipeRefreshLayout.bindSwipeRefreshLayoutColor(attach: Boolean?) {
    val c1 = ContextCompat.getColor(context, R.color.purple_200)
    val c2 = ContextCompat.getColor(context, R.color.purple_500)
    val c3 = ContextCompat.getColor(context, R.color.purple_700)

    val c4 = ContextCompat.getColor(context, R.color.teal_200)
    val c5 = ContextCompat.getColor(context, R.color.teal_700)
    setColorSchemeColors(c1, c2, c3, c4, c5)
}

@BindingAdapter("loadDrawable")
fun ImageView.loadImage(
    selected: Boolean
) {
    if (selected)
        setImageResource(R.drawable.ic_heart_filled) else setImageResource(R.drawable.ic_heart_border)
}

@BindingAdapter(value = ["loadImage", "loadImageProgress"], requireAll = false)
fun ImageView.loadImage(
    imagePath: String?,
    progress: ProgressBar? = null
) {
    progress?.visibility = View.VISIBLE
    Glide.with(this).load(imagePath)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progress?.visibility = View.INVISIBLE
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progress?.visibility = View.INVISIBLE
                return false
            }

        }).into(this)
}
