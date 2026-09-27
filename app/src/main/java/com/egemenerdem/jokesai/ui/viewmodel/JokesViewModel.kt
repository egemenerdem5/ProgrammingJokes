package com.egemenerdem.jokesai.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egemenerdem.jokesai.data.model.Joke
import com.egemenerdem.jokesai.data.repository.JokeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface JokesUiState {
    data object Loading : JokesUiState
    data class Success(val jokes: List<Joke>) : JokesUiState
    data class Error(val message: String) : JokesUiState
}

class JokesViewModel(
    private val repository: JokeRepository = JokeRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<JokesUiState>(JokesUiState.Loading)
    val uiState: StateFlow<JokesUiState> = _uiState.asStateFlow()

    init {
        loadJokes()
    }

    fun loadJokes() {
        viewModelScope.launch {
            _uiState.value = JokesUiState.Loading
            repository.fetchProgrammingJokes(amount = 10)
                .onSuccess { jokes ->
                    if (jokes.isEmpty()) {
                        _uiState.value = JokesUiState.Error("No programming jokes found.")
                    } else {
                        _uiState.value = JokesUiState.Success(jokes)
                    }
                }
                .onFailure { exception ->
                    _uiState.value = JokesUiState.Error(
                        exception.localizedMessage ?: "An unexpected error occurred while fetching jokes."
                    )
                }
        }
    }
}
