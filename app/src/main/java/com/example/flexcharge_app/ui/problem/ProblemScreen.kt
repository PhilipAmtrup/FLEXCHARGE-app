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
            contentTitle = dilemma.contentTitle,
            description = dilemma.description,
            questions = dilemma.questions.map { it.text },
            imageRes = dilemma.imageRes,
            onClicks = dilemma.questions.map { question ->
                {
                    val nextRoute = viewModel.getNextRoute(problemCode, question.text)
                    nextRoute?.let {
                        navController.navigate(it)
                    }
                }
            },
            navController = navController, // Pass the navController
            startRoute = "Problem_0" // Pass the start route to determine if back button should be shown
        )
    }
}
