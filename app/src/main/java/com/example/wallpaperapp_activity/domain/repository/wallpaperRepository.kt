package com.example.wallpaperapp_activity.domain.repository

import com.example.wallpaperapp_activity.data.api.utils.resource
import com.example.wallpaperapp_activity.domain.entities.wallpaperLink
import kotlinx.coroutines.flow.Flow

interface wallpaperRepository {

     fun getImage() : Flow<resource<List<wallpaperLink>>>

}