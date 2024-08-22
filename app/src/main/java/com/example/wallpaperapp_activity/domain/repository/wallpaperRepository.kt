package com.example.wallpaperapp_activity.domain.repository

import com.example.wallpaperapp_activity.data.api.model.picsumItem
import kotlinx.coroutines.flow.Flow

interface wallpaperRepository {

     fun getImage() : Flow<List<picsumItem>>

}