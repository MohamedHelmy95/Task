package com.promoclicks.domain.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject


class HeaderInterceptor @Inject constructor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .build()
        return chain.proceed(request)
    }
}