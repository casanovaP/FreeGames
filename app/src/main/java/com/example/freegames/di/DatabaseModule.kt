package com.example.freegames.di

import android.content.Context
import androidx.room.Room
import com.example.freegames.data.local.GamesDatabase
import com.example.freegames.data.local.dao.GamesDao
import com.example.freegames.data.repository.LocalDataSourceImpl
import com.example.freegames.domain.repository.LocalDataSource
import com.example.freegames.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context): GamesDatabase {
        return Room.databaseBuilder(
            context,
            GamesDatabase::class.java,
            Constants.GAMES_DATABASE
        ).build()
    }

    @Provides
    fun provideGamesDao(database: GamesDatabase): GamesDao {
        return database.gamesDao()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(gamesDao: GamesDao): LocalDataSource {
        return LocalDataSourceImpl(gamesDao = gamesDao)
    }
}