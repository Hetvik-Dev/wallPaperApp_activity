package com.example.wallpaperapp_activity.data.api

import com.example.wallpaperapp_activity.data.api.model.picsumItem
import com.example.wallpaperapp_activity.domain.repository.wallpaperRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class wallpaperRepoImplemant @Inject constructor(val picsumApi: PicsumApi) : wallpaperRepository{

    override fun getImage(): Flow<List<picsumItem>> {
        //Here we do retrofit call

    }
}