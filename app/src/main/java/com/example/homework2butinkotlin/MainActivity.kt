package com.example.homework2butinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2butinkotlin.ViewModels.WallpaperViewModel
import com.example.homework2butinkotlin.fragments.Wallpaper
import com.example.homework2butinkotlin.utils.WallpaperListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

class MainActivity : AppCompatActivity(), WallpaperListener{

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewmodel: WallpaperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayoutManager = GridLayoutManager(
            this,
            1,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView = findViewById(R.id.wallpaper_rv)
        recyclerView.apply{
            layoutManager= gridLayoutManager
            adapter = WallpaperAdapter().apply {
                listener = this@MainActivity
                }
            }


        viewmodel = ViewModelProvider(this).get(WallpaperViewModel::class.java)
        viewmodel.getWallpapers().observe(this, Observer { wallpaperList ->
            Log.d("_TAG:", "Got ${wallpaperList.size} wallpapers")
            (recyclerView.adapter as WallpaperAdapter).updateList(wallpaperList)
        })


    }

    override fun onScroll(recyclerView: RecyclerView, newState: Int) {

        if (!recyclerView.canScrollVertically(1))
        {
           viewmodel.getWallpapers()
        }


    }
}