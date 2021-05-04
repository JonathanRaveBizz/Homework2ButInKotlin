package com.example.homework2butinkotlin.utils

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WallpaperRepository {
    private val BASE_URL = "https://wall.alphacoders.com/api2.0/"
    private val API_KEY = "e1362fea4864a3e2f2dba8e1ef453831"
    private var page = 0
    private val method = "category"
    private val id = 3

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val wallpaperAPIService = retrofit.create((WallpaperAPIService::class.java))
    fun getWallpapers
}
