package com.example.freegames.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.freegames.domain.model.Game
import com.example.freegames.presentation.common.ListContent
import com.example.freegames.presentation.screen.home.HomeScreen
import com.example.freegames.utils.Constants.DETAILS_ARGUMENT_KEY

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun SetupNavhGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(
            Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }

        composable(route = Screen.Search.route) {

        }
    }
}