package com.example.wallpaperapp_activity.presantation.viewmodel

import com.example.wallpaperapp_activity.data.api.PicsumApi

sealed class wallpaperUistate {

    object Loading : wallpaperUistate()
    object EmptyList : wallpaperUistate()

    data class Success(val data : List<PicsumApiWallpaper>) : wallpaperUistate()
    data class Error(val message : String ) : wallpaperUistate()

}