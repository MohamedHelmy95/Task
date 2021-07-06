package com.promoclicks.task.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.promoclicks.task.util.ToastUtil.showToast

abstract class BaseActivity : AppCompatActivity() {
    protected val TAG = javaClass.simpleName

    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy {
            DataBindingUtil.setContentView<T>(this@BaseActivity, resId).apply {
                lifecycleOwner = this@BaseActivity
                executePendingBindings()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        super.onCreate(savedInstanceState)
    }

    fun onError(throwable: Throwable) {
        showToast(message = throwable.message + " ")
    }

}
