package com.riproad.android.interviewtestapp.ui.main

import com.riproad.android.interviewtestapp.network.RemoteServiceHelper

class SubwayEntrancesRepository(private val remoteServiceHelper: RemoteServiceHelper) {
    suspend fun getSubwayEntrances(timeStamp: HashMap<String, Long>) = remoteServiceHelper.getSubwayEntrances(timeStamp)
}