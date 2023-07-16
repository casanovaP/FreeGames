package com.example.freegames.domain.repository


import com.example.freegames.data.model.GameDto


interface RemoteDataSource {
    suspend fun getAllGames(): List<GameDto>
    suspend fun getSelectedGame(gameId: Int): GameDto
}