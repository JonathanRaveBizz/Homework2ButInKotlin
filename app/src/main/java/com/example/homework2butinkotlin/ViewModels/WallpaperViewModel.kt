package com.example.homework2butinkotlin.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2butinkotlin.utils.WallpaperItem
import com.example.homework2butinkotlin.utils.WallpaperRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WallpaperViewModel : ViewModel() {
    private val disposables : CompositeDisposable= CompositeDisposable()
    private val wallRepo = WallpaperRepository()
    private var wallpapers: MutableLiveData<List<WallpaperItem>> = MutableLiveData()

    fun getWallpapers : LiveData<List<WallpaperItem>>
    {
        loadWallpapers()
        return wallpapers
    }

    private fun loadWallpapers()
    {
        disposables.add(
            wallRepo.getWallpaperObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(this::wallpaperSuccess, this::onError))
    }
    private fun wallpapersSuccess(wallPaperItemList: List<WallpaperItem>)
    {
        wallpapers.postValue((wallPaperItemList.map {urlImage ->
            WallpaperItem(urlImage = urlImage)
        }))
    }
}