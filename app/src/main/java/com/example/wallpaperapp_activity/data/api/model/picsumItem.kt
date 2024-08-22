package com.example.wallpaperapp_activity.data.api.model

import com.google.gson.annotations.SerializedName

data class picsumItem(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,

    @SerializedName("download_url") //from API we are getting this but we rename it
    val downloadUrl: String //using with this name
)