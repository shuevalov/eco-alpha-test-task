package ru.shuevalov.eco_alpha_test_task.ui.screens.home

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.shuevalov.eco_alpha_test_task.data.model.Bin
import ru.shuevalov.eco_alpha_test_task.data.repository.AppRepository

class HomeViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    private fun validateInput(input: String): Boolean = input.length == 6 && input.isDigitsOnly()

    fun setCurrentBin(id: String) {
        if (validateInput(id)) {
            viewModelScope.launch {
                val bin = repository.getBinFromHttp(id).copy(bin = id)
                if (bin.scheme == "error") return@launch
                repository.insert(bin)
                _uiState.update { it.copy(currentBin = setOf(bin)) }
            }
        }
    }
}

data class HomeUiState(
    val currentBin: Set<Bin> = setOf()
)