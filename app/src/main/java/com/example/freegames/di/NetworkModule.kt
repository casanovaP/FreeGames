package com.example.freegames.di

import com.example.freegames.data.remote.GamesApi
import com.example.freegames.data.remote.LoggingInterceptor
import com.example.freegames.data.repository.RemoteDataSourceImpl
import com.example.freegames.domain.repository.RemoteDataSource
import com.example.freegames.utils.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): GamesApi {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(LoggingInterceptor())
                    .build()
            )
            .build()
            .create(GamesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(gamesApi: GamesApi) : RemoteDataSource {
        return RemoteDataSourceImpl(gamesApi = gamesApi)
    }
}