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
            title = dilemma.title,
            questions = dilemma.questions.map { it.text },
            imageRes = dilemma.imageRes,
            onClicks = dilemma.questions.map { question ->
                {
                    question.nextProblemCode?.let { nextCode ->
                        navController.navigate(nextCode)
                    }
                }
            }
        )
    }
}
