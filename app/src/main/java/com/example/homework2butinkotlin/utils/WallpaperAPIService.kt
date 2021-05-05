package com.example.homework2butinkotlin.utils

import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperAPIService {
    //@GET("wallpapers")
    fun getWallpapers(
        @Query("API_KEY") apiKey: String = "e1362fea4864a3e2f2dba8e1ef453831",
        @Query("method") method: String = "category",
        @Query( "id") id: Int = 3,
        @Query("page") page: Int
        )

}
