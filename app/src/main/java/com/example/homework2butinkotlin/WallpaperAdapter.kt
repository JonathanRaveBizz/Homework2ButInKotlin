package com.example.homework2butinkotlin

import WallpaperItem
import android.text.Layout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework2butinkotlin.utils.WallpaperListener

class WallpaperAdapter :RecyclerView.Adapter<WallpaperAdapter.ViewHolder>() {
    lateinit var listener: WallpaperListener

    private var wallpaperList: List<WallpaperItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.wallpaper_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = wallpaperList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wallpaperList[position])
    }
    fun updateList(newList: List<WallpaperItem>){
        this.wallpaperList= newList
        notifyDataSetChanged()
    }

    fun addToList(newList:List<WallpaperItem>) {
        wallpaperList = wallpaperList+newList
        notifyDataSetChanged()
    }


    inner class  ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private var wallpaperImageView: ImageView = itemView.findViewById(R.id.wallpaper_iv)
        private lateinit var wallpaperItem: WallpaperItem

        fun bind(paper: WallpaperItem) {
            wallpaperItem = paper
            wallpaperImageView.apply {
                Glide.with(itemView)
                    .load(paper.url_image)
                    .into(wallpaperImageView)
            }
        }

    }
}

