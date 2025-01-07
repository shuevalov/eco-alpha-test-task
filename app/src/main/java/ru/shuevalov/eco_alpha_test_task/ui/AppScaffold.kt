package ru.shuevalov.eco_alpha_test_task.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.shuevalov.eco_alpha_test_task.navigation.AppNavigation


@Composable
fun AppScaffold(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->
        AppNavigation(navController)
        padding
    }
}