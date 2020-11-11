package com.riproad.android.interviewtestapp.util

import com.riproad.android.interviewtestapp.model.SubwayEntrancesResponse

sealed class State {
    object Loading: State()
    data class Success(val response: SubwayEntrancesResponse): State()
    data class Failure(val error: Throwable): State()
}