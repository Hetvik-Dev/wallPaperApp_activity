package com.example.wallpaperapp_activity.data.api.utils

sealed class resource<T>(val data : T?= null , val message : String? = null) {

    class Success<T>(data : T) : resource<T> (data)

    class Error<T>(data : T?= null , message: String) : resource<T>(data , message)
}