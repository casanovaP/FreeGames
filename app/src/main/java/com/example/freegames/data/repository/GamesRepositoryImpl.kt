package com.example.freegames.data.repository

import com.example.freegames.domain.model.Game
import com.example.freegames.domain.model.toGame
import com.example.freegames.domain.repository.GamesRepository
import com.example.freegames.domain.repository.LocalDataSource
import com.example.freegames.domain.repository.RemoteDataSource
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : GamesRepository {
    override suspend fun getAllGames(): List<Game> {

        // let meh check if dat datass is available locally
        val cachedGames = localDataSource.getAllGames()
        if (cachedGames.isNotEmpty()) {
            return cachedGames.map { it.toGame() }
        }

        // grab some fresh from the API if you aint got any
        val gameDtos = remoteDataSource.getAllGames()

        // and slap that datass into the database
        localDataSource.insertGames(gameDtos)

        // now let meh grab it for ya and serve it HOT
        //i know, right?? this dirty mind...
        return gameDtos.map { it.toGame() }
    }

    override suspend fun getSelectedGame(gameId: Int): Game {
        return localDataSource.getSelectedGame(gameId).toGame()
    }

    override suspend fun searchGames(query: String): List<Game> {
        return localDataSource.searchGames(query).map { it.toGame() }
    }
}