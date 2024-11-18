package com.example.flexcharge_app.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flexcharge_app.ui.problem.ProblemScreen
import com.example.flexcharge_app.viewModel.DilemmasViewModel

@Composable
fun NavigationComponent(navController: NavHostController, viewModel: DilemmasViewModel) {
    val startRoute = "Problem_0"

    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        viewModel.dilemmas.forEach { dilemma ->
            composable(dilemma.problemCode) {
                val screen = ProblemScreen(viewModel, dilemma.problemCode)
                screen.Content(navController)
            }
        }
    }
}
