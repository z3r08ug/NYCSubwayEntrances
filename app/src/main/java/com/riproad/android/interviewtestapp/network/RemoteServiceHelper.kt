package com.riproad.android.interviewtestapp.network

class RemoteServiceHelper(private val remoteService: RemoteService) {
    suspend fun getSubwayEntrances(timestamp: HashMap<String, Long>) = remoteService.getSubwayEntrances(timestamp)
}