package com.example.freegames.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
    object Details: Screen("details/{gameId}") {
        fun passGameId(gameId: Int): String {
            return "details/$gameId"
        }
    }
    object Search: Screen("search_screen")
}