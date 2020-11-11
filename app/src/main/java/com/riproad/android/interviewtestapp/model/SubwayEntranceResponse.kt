package com.riproad.android.interviewtestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SubwayEntrancesResponse {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("result")
    @Expose
    var result: Result? = null
}