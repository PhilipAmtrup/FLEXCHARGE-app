package com.example.flexcharge_app.ui.problem

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.flexcharge_app.ui.Navigation.FlexScreen
import com.example.flexcharge_app.ui.components.ReusableDilemmaPage
import com.example.flexcharge_app.viewModel.DilemmasViewModel

class ProblemScreen(private val viewModel: DilemmasViewModel, private val problemCode: String) : FlexScreen {

    override fun getRoute() = problemCode

    @Composable
    override fun Content(navController: NavController) {
        val dilemma = viewModel.getDilemmaByCode(problemCode)

        ReusableDilemmaPage(
            headerTitle = dilemma.title,
            contentTitle = "Vælg et af punkterne",
            questions = dilemma.questions.map { it.text },
            imageRes = dilemma.imageRes,
            onClicks = dilemma.questions.map { question ->
                {
                    question.nextProblemCode?.let { nextCode ->
                        navController.navigate(nextCode)
                    }
                }
            },
            navController = navController, // Pass the navController
            startRoute = "Problem_0" // Pass the start route to determine if back button should be shown
        )
    }
}
