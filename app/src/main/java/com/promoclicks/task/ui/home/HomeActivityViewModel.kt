package com.promoclicks.task.ui.home

import androidx.lifecycle.MutableLiveData
import com.promoclicks.data.response.HomeResponse
import com.promoclicks.task.core.BaseResponse
import com.promoclicks.task.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(private val repo: HomeRepository) :
    BaseViewModel() {

    val response: StateFlow<BaseResponse<HomeResponse>?> = repo.response.asStateFlow()

    val userName = MutableLiveData<String>("Mohamed Helmy")
    val image =
        MutableLiveData<String>("https://i.pinimg.com/236x/e5/fe/e7/e5fee79558b408b9625d954a9ccb9234.jpg")

    init {
        fetchHome()
    }

    fun fetchHome() = launchTask { repo.getHome() }

}
