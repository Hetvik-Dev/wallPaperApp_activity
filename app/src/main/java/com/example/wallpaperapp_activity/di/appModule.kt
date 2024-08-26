package com.example.wallpaperapp_activity.di

import com.example.wallpaperapp_activity.data.api.PicsumApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class appModule {

    companion object {
        @Provides
        @Singleton
        fun retrofitApiProvider(): PicsumApi {
            return Retrofit.Builder()
//            .baseUrl()

                .build()
                .create(PicsumApi::class.java)
        }
    }
}