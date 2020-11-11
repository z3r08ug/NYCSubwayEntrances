package com.riproad.android.interviewtestapp.network

import android.os.Environment
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


object RemoteDataSource {

    private const val baseURL = "https://ds-test.riproad.com/RRUtils/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseURL)
//                .client(httpClientConfig(loggingInterceptor()))
                .addConverterFactory(GsonConverterFactory.create()) //add call adapter to convert the response to RxJava observable
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun httpClientConfig(interceptor: HttpLoggingInterceptor): OkHttpClient? {
        val httpCacheDirectory = File(Environment.getExternalStorageDirectory(), "HttpCache") // Here to facilitate the file directly on the SD Kagan catalog HttpCache in ， Generally put in context.getCacheDir() in
        val cacheSize: Long = 10 * 1024 * 1024 // 10 MiB
        val cache = Cache(httpCacheDirectory, cacheSize)
        return OkHttpClient.Builder().cache(cache).addInterceptor(interceptor).build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    val subwayEntrancesService: RemoteService = getRetrofit().create(RemoteService::class.java)
}