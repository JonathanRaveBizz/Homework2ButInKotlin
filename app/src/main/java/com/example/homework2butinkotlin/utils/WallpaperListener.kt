package com.example.homework2butinkotlin.utils

import androidx.recyclerview.widget.RecyclerView

interface AdapterListener{

}

interface WallpaperListener {
    fun onScroll(recyclerView: RecyclerView, newState : Int)
}