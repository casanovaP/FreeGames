package com.example.freegames.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection.Companion.In
import androidx.navigation.NavHostController
import com.example.freegames.presentation.components.GameItem

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavHostController
) {
    val gamesState = viewModel.gamesState.value
    val loadingState = viewModel.loadingState.value

    Scaffold(
        topBar = {
            HomeTopBar {
                // Handle search button click here
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (loadingState) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(items = gamesState) { game ->
                        GameItem(game = game, navController = navController)
                    }
                }
            }
        }
    }
}
