package com.example.freegames.domain.use_cases.get_games

import com.example.freegames.domain.model.Game
import com.example.freegames.domain.repository.GamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GamesRepository
){
    suspend operator fun  invoke(): List<Game> {
        return withContext(Dispatchers.IO) { repository.getAllGames() }
    }
}