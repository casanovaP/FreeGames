package com.example.freegames.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.freegames.presentation.components.GameItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                // Handle search click
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