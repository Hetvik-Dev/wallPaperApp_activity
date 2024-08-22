package com.example.wallpaperapp_activity.di

import com.example.wallpaperapp_activity.data.api.PicsumApi
import dagger.Provides
import retrofit2.Retrofit

class appModule {

    @Provides
    fun retrofitApiProvider(
    ): PicsumApi {
        return Retrofit.Builder()
//            .baseUrl()

            .build()
            .create(PicsumApi::class.java)
    }
}