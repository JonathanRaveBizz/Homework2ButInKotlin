package com.example.homework2butinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework2butinkotlin.fragments.Wallpaper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
        {
            supportFragmentManager
                .beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.wallpaper_fragment, Wallpaper.newInstance())
        }
    }
}