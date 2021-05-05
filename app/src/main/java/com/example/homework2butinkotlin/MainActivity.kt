package com.example.homework2butinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2butinkotlin.ViewModels.WallpaperViewModel
import com.example.homework2butinkotlin.fragments.Wallpaper

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewmodel: WallpaperViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerView = findViewById(R.id.wallpaper_rv)
        recyclerView.apply{
            layoutManager= linearLayoutManager
            adapter = WallpaperAdapter()

        }

        viewmodel = ViewModelProvider(this).get(WallpaperViewModel::class.java)
        viewmodel.get

    }
}