package com.example.homework2butinkotlin.utils

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WallpaperItem (
    @SerializedName("file_size")
    var fileSize: String? = null,

    @SerializedName("file_type")
    var fileType: String? = null,

    @Expose
    var height: String? = null,

    @Expose
    var id: String? = null,

    @SerializedName("url_image")
    var urlImage: String? = null,

    @SerializedName("url_page")
    var urlPage: String? = null,

    @SerializedName("url_thumb")
    var urlThumb: String? = null,

    @Expose
    var width: String? = null

        )
{

}
