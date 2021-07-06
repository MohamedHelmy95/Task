package com.promoclicks.task.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

abstract class BaseRepository {


    private val defaultDispatcher = Dispatchers.IO
    protected suspend fun <T : Any> buildApi(task: suspend () -> T) = flow<BaseResponse<T>> {
        emit(BaseResponse.Success(data = task()))
    }
        .flowOn(defaultDispatcher)
        .onStart { emit(BaseResponse.Loading(loading = true)) }
        .catch { throwable ->
            emit(BaseResponse.Error(throwable = throwable))
        }

}