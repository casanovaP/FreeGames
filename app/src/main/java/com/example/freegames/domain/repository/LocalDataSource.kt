package com.example.freegames.domain.repository

import com.example.freegames.data.model.GameDto


interface LocalDataSource {
    suspend fun getAllGames(): List<GameDto>
    suspend fun getSelectedGame(gameId: Int): GameDto
    suspend fun searchGames(query: String): List<GameDto>
    suspend fun insertGames(games: List<GameDto>)
    suspend fun clearGames()
}