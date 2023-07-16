package com.example.freegames.domain.use_cases.search_games

import com.example.freegames.domain.model.Game
import com.example.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class SearchGamesUseCase @Inject constructor(
    private val repository: GamesRepository
) {
    suspend operator fun invoke(query: String): List<Game> {
        return repository.searchGames(query)
    }
}