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
import com.example.homework2butinkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var viewmodel: WallpaperViewModel
    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.wallpaperRv.apply {
            layoutManager = linearLayoutManager
            adapter = WallpaperAdapter().apply {
                //listener = this@MainActivity
            }
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1)) {
                        viewmodel.getWallpapers()
                    }
                    if(!recyclerView.canScrollVertically(-1))
                        viewmodel.addWallpapers()
                }

            })

        }
//

        viewmodel = ViewModelProvider(this).get(WallpaperViewModel::class.java)
        //viewmodel.getWallpapers()
        viewmodel.getWallpapers().observe(this, Observer { wallpaperList ->
            //Log.d("_TAG:", "Got ${wallpaperList.size} wallpapers")
            (binding.wallpaperRv.adapter as WallpaperAdapter).updateList(wallpaperList)
        })
        viewmodel.addWallpapers().observe(this, Observer { wallpaperList ->
            //Log.d("_TAG:", "Got ${wallpaperList.size} wallpapers")
            (binding.wallpaperRv.adapter as WallpaperAdapter).updateList(wallpaperList)
        })


    }


}