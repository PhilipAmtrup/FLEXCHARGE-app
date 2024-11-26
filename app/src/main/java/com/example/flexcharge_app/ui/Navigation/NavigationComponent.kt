package com.example.flexcharge_app.Navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flexcharge_app.ui.components.SupportFormScreen
import com.example.flexcharge_app.ui.problem.ProblemScreen
import com.example.flexcharge_app.viewModel.DilemmasViewModel
import com.example.flexcharge_app.ui.components.PaymentGuidePage
import com.example.flexcharge_app.viewModel.SupportFormViewModel
import com.example.flexcharge_app.viewModel.SupportFormViewModelFactory
import com.example.flexcharge_app.data.api.EmailApi
import com.example.flexcharge_app.data.repository.EmailRepository

@Composable
fun NavigationComponent(navController: NavHostController, viewModel: DilemmasViewModel) {
    val startRoute = "Problem_0" // Set the route name of your starting screen

    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        viewModel.dilemmas.forEach { dilemma ->
            composable(dilemma.problemCode) {
                // Render ProblemScreen for each dilemma
                val screen = ProblemScreen(viewModel, dilemma.problemCode)
                screen.Content(navController)
            }
        }

        composable("SupportForm/{errorCode}") { backStackEntry ->
            val errorCode = backStackEntry.arguments?.getString("errorCode") ?: ""
            val emailApi = EmailApi()
            val emailRepository = EmailRepository(emailApi)
            val supportFormViewModel: SupportFormViewModel = viewModel(
                factory = SupportFormViewModelFactory(emailRepository)
            )
            SupportFormScreen(
                navController = navController,
                startRoute = startRoute,
                viewModel = supportFormViewModel,
                errorCode = errorCode // Pass errorCode here
            )
        }

        composable("PaymentGuide") {
            PaymentGuidePage(navController = navController, startRoute = startRoute)
        }

        }
    }

