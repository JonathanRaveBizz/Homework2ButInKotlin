package com.example.homework2butinkotlin.utils

import retrofit2.http.Query

interface WallpaperAPIService {
    @get("wallpapers")
    fun getWallpapwers(
        @Query("API_KEY") apiKey: String,
        @Query()

        )

}
