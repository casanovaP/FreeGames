package com.example.freegames.presentation.screen.home


import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegames.domain.model.Game
import com.example.freegames.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(useCases: UseCases) : ViewModel() {

    private val getGamesUseCase = useCases.getGamesUseCase

    private val _gamesState = mutableStateOf<List<Game>>(emptyList())
    val gamesState: State<List<Game>> = _gamesState

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    init {
        getAllGames()
    }

    private fun getAllGames() {
        viewModelScope.launch {
            try {
                _loadingState.value = true
                _gamesState.value = getGamesUseCase.invoke()
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error retrieving games: ${e.message}")
            } finally {
                _loadingState.value = false
            }
        }
    }
}
