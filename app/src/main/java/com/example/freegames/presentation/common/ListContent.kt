package com.example.freegames.presentation.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.freegames.domain.model.Game
import com.example.freegames.presentation.components.GameItem

@Composable
fun ListContent(
    games: List<Game>,
    navController: NavHostController
) {
    LazyColumn {
        items(
            items = games,
            key = {game: Game -> game.id}
        ) {game ->
            GameItem(game = game, navController = navController)
        }
    }
}
