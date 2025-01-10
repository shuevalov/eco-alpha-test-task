package ru.shuevalov.eco_alpha_test_task.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel
import ru.shuevalov.eco_alpha_test_task.ui.theme.EcoalphatesttaskTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    HomeContent(
        uiState = uiState,
        setBin = viewModel::setCurrentBin
    )
}

@Composable
fun HomeContent(
    uiState: HomeUiState,
    setBin: (String) -> Unit
) {
    var binId by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 80.dp),
            value = binId,
            onValueChange = { value ->
                if (value.length <= 6) {
                    binId = value.filter { it.isDigit() }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            if (uiState.currentBin.isEmpty()) {
                Text(
                    modifier = Modifier.align(Alignment.TopCenter),
                    text = "Enter BIN",
                    fontSize = 20.sp
                )
            } else {
                Column(
                    modifier = Modifier,
                ) {
                    val bin = uiState.currentBin.last()
                    Text(
                        text = "Bin: ${bin.bin ?: "-"}",
                        fontSize = 20.sp
                    )
                    Text("Country: ${bin.country?.name ?: "-"}")
                    Text("Coordinates: ${bin.country?.latitude ?: "-"} / ${bin.country?.longitude ?: "-"}")
                    Text("Scheme: ${bin.scheme ?: "-"}")
                    Text("Bank: ${bin.bank?.name ?: "-"}")
                    Text("Bank url: ${bin.bank?.url ?: "-"}")
                    Text("Bank phone: ${bin.bank?.phone ?: "-"}")
                    Text("Bank city: ${bin.bank?.city ?: "-"}")
                }
            }
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