package com.example.freegames.di

import com.example.freegames.data.repository.GamesRepositoryImpl
import com.example.freegames.domain.repository.GamesRepository
import com.example.freegames.domain.use_cases.UseCases
import com.example.freegames.domain.use_cases.get_game.GetGameUseCase
import com.example.freegames.domain.use_cases.get_games.GetGamesUseCase
import com.example.freegames.domain.use_cases.search_games.SearchGamesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGamesRepository(repositoryImpl: GamesRepositoryImpl): GamesRepository {
        return repositoryImpl
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: GamesRepository): UseCases {
        return UseCases(
            getGamesUseCase = GetGamesUseCase(repository),
            getGameUseCase = GetGameUseCase(repository),
            searchGamesUseCase = SearchGamesUseCase(repository)
        )
    }
}