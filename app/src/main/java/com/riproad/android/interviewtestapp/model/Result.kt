package com.riproad.android.interviewtestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Result {
    @SerializedName("data")
    @Expose
    lateinit var data: List<List<String>>
}