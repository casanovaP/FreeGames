package com.example.freegames.domain.use_cases.get_games

import com.example.freegames.domain.model.Game
import com.example.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GamesRepository
){
    suspend operator fun  invoke(): List<Game> {
        return repository.getAllGames()
    }
}