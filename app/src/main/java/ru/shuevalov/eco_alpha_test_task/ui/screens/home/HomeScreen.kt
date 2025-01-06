package ru.shuevalov.eco_alpha_test_task.ui.screens.home

import android.widget.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.shuevalov.eco_alpha_test_task.data.model.Bin
import ru.shuevalov.eco_alpha_test_task.ui.theme.EcoalphatesttaskTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    HomeContent(
        uiState = uiState,
        setBin = viewModel::setCurrentBin
    )

    BottomAppBar {
        
    }
}

@Composable
fun HomeContent(
    uiState: HomeUiState,
    setBin: (String) -> Unit
) {
    var binId by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 80.dp),
            value = binId,
            onValueChange = { binId = it }
        )

        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 20.dp),
            onClick = { setBin(binId) }
        ) {
            Text("get BIN info")
        }

        BinInfo(uiState)
    }
}
@Composable
fun BinInfo(
    uiState: HomeUiState
) {
    if (uiState.currentBin.isEmpty()) {
        Text("Enter BIN")
    } else {
        Row {

            Text(uiState.currentBin.last().scheme)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    EcoalphatesttaskTheme {
        HomeContent(HomeUiState()) { }
    }
}