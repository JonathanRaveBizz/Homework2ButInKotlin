package com.example.homework2butinkotlin

import WallpaperItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2butinkotlin.utils.WallpaperRepository

class WallpaperRecyclerView: ViewModel()
{
    val wallRepo = WallpaperRepository()
    var wallpapers: MutableLiveData<List<WallpaperItem>>? = null
    get()
    {
        if (wallpapers == null)
        {
            wallpapers = MutableLiveData()
            loadWallpapers()
        }
        return wallpapers
    }
    fun loadWallpapers()
    {
      /* wallRepo.wallpaperCall.enque(object : callback<WallpaperRequest?>)
        {
            call: call
        }*/
    }


}