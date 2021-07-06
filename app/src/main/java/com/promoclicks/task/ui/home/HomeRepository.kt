package com.promoclicks.task.ui.home


import com.promoclicks.data.response.HomeResponse
import com.promoclicks.domain.remote.service.ApiService
import com.promoclicks.task.core.BaseRepository
import com.promoclicks.task.core.BaseResponse
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import javax.inject.Inject

@ViewModelScoped
class HomeRepository @Inject constructor(
    private val apiService: ApiService
) : BaseRepository() {

    val response = MutableStateFlow<BaseResponse<HomeResponse>?>(null)

    suspend fun getHome() = response.emitAll(flow = buildApi { buildHomeResponse() })
    private suspend fun buildHomeResponse(): HomeResponse = apiService.getHome()


}