package ru.shuevalov.eco_alpha_test_task.ui.screens.bins

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.shuevalov.eco_alpha_test_task.data.model.Bin
import ru.shuevalov.eco_alpha_test_task.ui.screens.home.HomeContent
import ru.shuevalov.eco_alpha_test_task.ui.theme.EcoalphatesttaskTheme

@Composable
fun BinsScreen(viewModel: BinsViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val searchText by viewModel.searchText.collectAsState()

    BinsContent(
        uiState = uiState,
        searchText = searchText,
        onSearchTextChange = viewModel::onSearchTextChange,
        deleteBin = viewModel::deleteBin
    )
}

@Composable
fun BinsContent(
    uiState: BinsUiState,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    deleteBin: (Bin) -> Unit
) {
    Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(32.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = { Text("search") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(uiState.bins) {
                BinItem(
                    modifier = Modifier.fillMaxWidth(),
                    bin = it
                )
            }
        }
    }
}

@Composable
fun BinItem(
    modifier: Modifier,
    bin: Bin
) {
    Text(bin.scheme)

    
}

@Preview(showBackground = true)
@Composable
private fun BinsPreview() {
    EcoalphatesttaskTheme {
        BinsContent(
            uiState = BinsUiState(),
            searchText = "",
            deleteBin = {},
            onSearchTextChange = {}
        )
    }
}