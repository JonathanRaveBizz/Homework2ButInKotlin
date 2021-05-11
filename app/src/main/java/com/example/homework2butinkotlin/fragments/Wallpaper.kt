package com.example.homework2butinkotlin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework2butinkotlin.R
import com.example.homework2butinkotlin.ViewModels.WallpaperViewModel
import com.example.homework2butinkotlin.databinding.WallpaperFragmentBinding

class Wallpaper : Fragment() {
    private lateinit var binding: WallpaperFragmentBinding

    companion object {
        fun newInstance() = Wallpaper()
    }

    private lateinit var viewModel: WallpaperViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WallpaperFragmentBinding.inflate(inflater, container, false)
        var view = binding.root
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WallpaperViewModel::class.java)
        // TODO: Use the ViewModel
    }

}