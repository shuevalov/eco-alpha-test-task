package ru.shuevalov.eco_alpha_test_task.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    fun setCurrentBin(id: String) {
        viewModelScope.launch {
            val bin = repository.getBinById(id)
            repository.insert(bin)
            _uiState.update { it.copy(currentBin = setOf(bin)) }
        }
    }

    fun getBinById(id: String): Bin {
        var bin: Bin? = null
        viewModelScope.launch {
            bin = repository.getBinById(id)
            repository.insert(bin!!)
        }
        return bin!!
    }
}

data class HomeUiState(
    val currentBin: Set<Bin> = setOf()
)