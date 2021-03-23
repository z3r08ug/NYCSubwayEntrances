package com.riproad.android.interviewtestapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.riproad.android.interviewtestapp.util.State
import kotlinx.coroutines.Dispatchers

class SubwayEntrancesViewModel(private val subwayEntrancesRepository: SubwayEntrancesRepository) : ViewModel() {
    fun getSubwayEntrances() = liveData(Dispatchers.IO) {
        emit(State.Loading)
        try {
            val timestamp = System.currentTimeMillis()
            val json = HashMap<String, Long>()
            json["timestamp"] = timestamp
            emit(State.Success(subwayEntrancesRepository.getSubwayEntrances(json)))
        } catch (exception: Exception) {
            emit(State.Failure(exception))
        }
    }
}