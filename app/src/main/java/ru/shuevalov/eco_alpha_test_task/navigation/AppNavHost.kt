package ru.shuevalov.eco_alpha_test_task.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.shuevalov.eco_alpha_test_task.ui.AppScaffold
import ru.shuevalov.eco_alpha_test_task.ui.screens.bins.BinsScreen
import ru.shuevalov.eco_alpha_test_task.ui.screens.home.HomeScreen
import ru.shuevalov.eco_alpha_test_task.ui.screens.home.HomeUiState

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String = "Home"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = "Home") {
            HomeScreen()
        }

        composable(route = "History") {
            BinsScreen()
        }
    }
}
