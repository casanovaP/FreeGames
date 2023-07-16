package com.example.freegames.domain.use_cases.get_game

import com.example.freegames.domain.model.Game
import com.example.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(
    private val repository: GamesRepository
) {
    suspend operator fun invoke(gameId: Int): Game {
        return repository.getSelectedGame(gameId)
    }
}