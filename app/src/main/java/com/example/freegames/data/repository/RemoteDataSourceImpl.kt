package com.example.freegames.data.repository


import com.example.freegames.data.model.GameDto
import com.example.freegames.data.remote.GamesApi
import com.example.freegames.domain.repository.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val gamesApi: GamesApi) : RemoteDataSource {
    override suspend fun getAllGames(): Response<List<GameDto>> {
        return gamesApi.getAllGames()
    }


    override suspend fun getSelectedGame(gameId: Int): GameDto {
        return gamesApi.getSelectedGame(gameId)
    }
}