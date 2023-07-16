package com.example.freegames.data.repository

import com.example.freegames.data.local.dao.GamesDao
import com.example.freegames.data.model.GameDto
import com.example.freegames.domain.repository.LocalDataSource

class LocalDataSourceImpl(private val gamesDao: GamesDao) : LocalDataSource {
    override suspend fun getAllGames(): List<GameDto> {
        return gamesDao.getAllGames()
    }

    override suspend fun getSelectedGame(gameId: Int): GameDto {
        return gamesDao.getSlecetedGame(gameId)
    }

    override suspend fun searchGames(query: String): List<GameDto> {
        return gamesDao.searchGames(query)
    }

    override suspend fun insertGames(games: List<GameDto>) {
        return gamesDao.addGames(games)
    }

    override suspend fun clearGames() {
        return gamesDao.deleteAllGames()
    }
}