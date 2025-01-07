package ru.shuevalov.eco_alpha_test_task.ui.screens.bins

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.shuevalov.eco_alpha_test_task.data.model.Bin
import ru.shuevalov.eco_alpha_test_task.data.repository.AppRepository

class BinsViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val  _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    val uiState = repository.getAllBins().map {
            BinsUiState(it)
        }.combine(_searchText) { bins, text ->
            if (text.isBlank()) {
                bins.bins
            } else {
                bins.bins.filter {
                    it.scheme.contains(text) // todo: change to bin number
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = BinsUiState()
        )

    fun deleteBin(bin: Bin) = viewModelScope.launch {
        repository.delete(bin)
    }

}

data class BinsUiState(
    val bins: List<Bin> = emptyList()
)