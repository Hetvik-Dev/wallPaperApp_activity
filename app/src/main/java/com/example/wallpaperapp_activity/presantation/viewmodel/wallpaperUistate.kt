package com.example.wallpaperapp_activity.presantation.viewmodel

import com.example.wallpaperapp_activity.domain.entities.wallpaperLink

sealed class wallpaperUistate {

    object Loading : wallpaperUistate()
    object EmptyList : wallpaperUistate()

    data class Success(val data : List<wallpaperLink>) : wallpaperUistate()
    data class Error(val message : String ) : wallpaperUistate()

}