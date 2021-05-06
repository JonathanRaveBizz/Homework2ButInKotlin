package com.example.homework2butinkotlin

import android.text.Layout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework2butinkotlin.utils.WallpaperItem

class WallpaperAdapter :RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {
    //lateinit listener: wallpaperListener
    var wallpaperList: List<WallpaperItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.wallpaper_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = wallpaperList.size

    override fun onBindViewHolder(holder: WallpaperAdapter.ViewHolder, position: Int) {
        holder.bind(wallpaperList[position])
    }
    fun updateList(newList: List<WallpaperItem>){
        this.wallpaperList= newList
        notifyDataSetChanged()
    }
    inner class  ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        private var wallpaperImageView: ImageView = itemView.findViewById(R.id.wallpaper_iv)
        private lateinit var wallpaperItem: WallpaperItem

        fun bind(paper: WallpaperItem) {
            wallpaperItem = paper
            wallpaperImageView.apply {
                Glide.with(itemView)
                    .load(wallpaperItem.urlImage)
                    .into(wallpaperImageView)
            }
        }
    }


}