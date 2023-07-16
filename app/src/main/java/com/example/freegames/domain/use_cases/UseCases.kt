package com.example.freegames.domain.use_cases

import com.example.freegames.domain.use_cases.get_game.GetGameUseCase
import com.example.freegames.domain.use_cases.get_games.GetGamesUseCase
import com.example.freegames.domain.use_cases.search_games.SearchGamesUseCase

data class UseCases(
    val getGameUseCase: GetGameUseCase,
    val getGamesUseCase: GetGamesUseCase,
    val searchGamesUseCase: SearchGamesUseCase
)