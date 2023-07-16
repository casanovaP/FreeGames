package com.example.freegames.domain.repository


import com.example.freegames.domain.model.Game

interface GamesRepository {
    suspend fun getAllGames(): List<Game>
    suspend fun getSelectedGame(gameId: Int): Game
    suspend fun searchGames(query: String): List<Game>
}