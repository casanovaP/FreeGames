package com.example.freegames.domain.repository


import com.example.freegames.data.model.GameDto
import retrofit2.Response


interface RemoteDataSource {
    suspend fun getAllGames(): Response<List<GameDto>>
    suspend fun getSelectedGame(gameId: Int): GameDto
}