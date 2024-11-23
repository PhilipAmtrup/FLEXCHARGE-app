package com.example.flexcharge_app.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flexcharge_app.ui.components.SimpleHeader
import com.example.flexcharge_app.ui.components.SupportFormScreen
import com.example.flexcharge_app.ui.problem.ProblemScreen
import com.example.flexcharge_app.viewModel.DilemmasViewModel
import com.example.flexcharge_app.ui.components.PaymentGuidePage

@Composable
fun NavigationComponent(navController: NavHostController, viewModel: DilemmasViewModel) {
    val startRoute = "Problem_0" // Set the route name of your starting screen

    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        viewModel.dilemmas.forEach { dilemma ->
            composable(dilemma.problemCode) {
                // Remove SimpleHeader here, as ReusableDilemmaPage already includes it.
                val screen = ProblemScreen(viewModel, dilemma.problemCode)
                screen.Content(navController)
            }
        }

        // Add a new route for the SupportFormScreen
        composable("SupportForm") {
            SupportFormScreen(navController = navController, startRoute = startRoute)
        }
        composable("PaymentGuide") {
            PaymentGuidePage(navController = navController, startRoute = startRoute)
        }

    }
}
