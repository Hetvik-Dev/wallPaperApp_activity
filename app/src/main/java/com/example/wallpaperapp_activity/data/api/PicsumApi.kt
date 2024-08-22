package com.example.wallpaperapp_activity.data.api

import com.example.wallpaperapp_activity.data.api.model.picsumItem
import com.example.wallpaperapp_activity.data.api.utils.constants.BASE_URL
import com.example.wallpaperapp_activity.data.api.utils.constants.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface PicsumApi {

    @GET(BASE_URL +  END_POINT)
    fun getWallpaperImage(

        @Query("page") page : Int = 1 , @Query("limit") limit : Int = 100

    ): List<picsumItem>?

}


