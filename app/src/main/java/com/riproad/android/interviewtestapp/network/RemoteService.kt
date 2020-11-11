package com.riproad.android.interviewtestapp.network

import com.riproad.android.interviewtestapp.model.SubwayEntrancesResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteService {
    @POST("subwayEntrances/nyc")
    suspend fun getSubwayEntrances(@Body timeStamp: HashMap<String, Long>): SubwayEntrancesResponse
}