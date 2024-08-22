package com.example.wallpaperapp_activity.presantation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.wallpaperapp_activity.domain.entities.wallpaperLink
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class wallpaperViewModel : ViewModel(){

    //Live data's work will be here
    private val _wallpaperList : MutableStateFlow<wallpaperUistate>
    = MutableStateFlow(wallpaperUistate.Loading)

    val wallpaperList get() = _wallpaperList.asStateFlow()

    fun fetchWallpapers() : List<wallpaperLink> {

    }
}