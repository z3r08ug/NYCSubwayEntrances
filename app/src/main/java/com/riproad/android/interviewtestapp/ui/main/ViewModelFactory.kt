package com.riproad.android.interviewtestapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riproad.android.interviewtestapp.network.RemoteServiceHelper

class ViewModelFactory(private val remoteServiceHelper: RemoteServiceHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubwayEntrancesViewModel::class.java)) {
            return SubwayEntrancesViewModel(SubwayEntrancesRepository(remoteServiceHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}