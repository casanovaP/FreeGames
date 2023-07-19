package com.example.freegames.data.repository

import android.util.Log
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
        /**
        // let meh check if dat datass is available locally
        val cachedGames = localDataSource.getAllGames()
        if (cachedGames.isNotEmpty()) {
        Log.d("GamesRepository", "Retrieved games from local data source")
        return cachedGames.map { it.toGame() }
        }

        // grab some fresh from the API if you aint got any
        Log.d("GamesRepository", "Fetching games from API")
        val gameDtos = remoteDataSource.getAllGames()

        // and slap that datass into the database
        Log.d("GamesRepository", "Inserting games into local database: $gameDtos")
        localDataSource.insertGames(gameDtos)

        // now let meh grab it for ya and serve it HOT
        //i know, right?? this dirty mind...
        Log.d("GamesRepository", "Retrieved games from API and inserted into local database")
        return gameDtos.map { it.toGame() }
        }
         **/
        val response = remoteDataSource.getAllGames()
        if (response.isSuccessful) {
            val gameDtos = response.body() ?: emptyList()

            // Insert games into the local database
            localDataSource.insertGames(gameDtos)

            // Map the gameDtos to Game domain models
            return gameDtos.map { it.toGame() }
        } else {
            // Handle error case
            throw Exception("Error retrieving games: ${response.message()}")
        }
    }


    override suspend fun getSelectedGame(gameId: Int): Game {
        return localDataSource.getSelectedGame(gameId).toGame()
    }

    override suspend fun searchGames(query: String): List<Game> {
        return localDataSource.searchGames(query).map { it.toGame() }
    }
}
