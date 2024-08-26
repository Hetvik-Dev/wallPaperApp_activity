package com.example.wallpaperapp_activity.data.api

import com.example.wallpaperapp_activity.data.api.utils.resource
import com.example.wallpaperapp_activity.domain.entities.wallpaperLink
import com.example.wallpaperapp_activity.domain.repository.wallpaperRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class wallpaperRepoImplemant @Inject constructor(val picsumApi: PicsumApi) : wallpaperRepository{

    override fun getImage(): Flow<resource<List<wallpaperLink>>> = flow{
        //Here we do retrofit call

        try {
            val respone = picsumApi.getWallpaperImage()

            val downloadLinks: List<wallpaperLink>

            respone?.let {//same as if condition that checks if it is null then . .

                downloadLinks = respone.map {
                    wallpaperLink(it.downloadUrl)
                }
                emit(resource.Success(downloadLinks))
            }
        }catch ( e : Exception){
            var errorOutput = ""
            if(e.message != null ){
                errorOutput = e.message!!
            }else{
                errorOutput = "Unknown Error..."
            }
            emit(resource.Error(null , errorOutput))
        }

    }
}