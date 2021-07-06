package com.promoclicks.domain.remote.service

import com.promoclicks.data.EndPoint.urlConstant
import com.promoclicks.data.response.HomeResponse
import retrofit2.http.GET


interface ApiService {


    @GET(value = urlConstant)
    suspend fun getHome(): HomeResponse

}