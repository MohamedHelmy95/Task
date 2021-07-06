package com.promoclicks.task.util

import android.content.Context
import android.widget.Toast


object ToastUtil {


    fun Context.showToast(
        message: String
    ) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

}


