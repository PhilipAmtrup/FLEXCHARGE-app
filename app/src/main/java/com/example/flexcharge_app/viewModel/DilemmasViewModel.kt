package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import com.example.flexcharge_app.R

data class Dilemma(
    val problemCode: String,
    val title: String,
    val questions: List<Question>,
    val imageRes: Int,
    val description: String,
    val contentTitle: String

)

data class Question(
    val text: String,
    val nextProblemCode: String?,
    val goesToSupportForm: Boolean,
    val goesToGuideForm: Boolean
)

class DilemmasViewModel : ViewModel() {

    val dilemmas = listOf(
        Dilemma(
            problemCode = "Problem_0",
            title = "FLEXCHARGE App",
            contentTitle = "Vælg et af punkterne",
            questions = listOf(
                Question("Er du ny kunde?", "Problem_1", goesToSupportForm = false, goesToGuideForm = false),
                Question("Jeg har problemer med min ladestation?", "Problem_2", goesToSupportForm = false, goesToGuideForm = false),
                Question("Har du problemer med betalingen af din opladning?", "Problem_3", goesToSupportForm = false, goesToGuideForm = false),
                Question("Jeg har et andet problem?", "SupportForm", goesToSupportForm = true, goesToGuideForm = false)
            ),
            description = "",
            imageRes = R.drawable.forside
        ),
        Dilemma(
            problemCode = "Problem_1",
            title = "Er du ny kunde?",
            contentTitle = "Vælg et af punkterne",
            questions = listOf(
                Question("Hvordan får jeg installeret en ny ladestation?", nextProblemCode = "SupportForm", goesToSupportForm = true, goesToGuideForm = false),
                Question("Hvordan bruger jeg betalings app'en?", nextProblemCode = "PaymentGuide", goesToSupportForm = false, goesToGuideForm = true)
            ),
            description = "",
            imageRes = R.drawable.er_du_ny_kunde
        ),
        Dilemma(
            problemCode = "Problem_2",
            title = "Jeg har problemer med min ladestation?",
            contentTitle = "Vælg et af punkterne",
            questions = listOf(
                Question("Elbilen melder fejl, hvad gør jeg?", "Problem_6", goesToSupportForm = false, goesToGuideForm = false),
                Question("Ladestationen lyser rød, hvad gør jeg?", "SupportForm", goesToSupportForm = true, goesToGuideForm = false),
                Question("Jeg kan ikke få ladekablet ud af ladestation", "SupportForm", goesToSupportForm = true, goesToGuideForm = false),
                Question("Jeg har et andet problem", "SupportForm", goesToSupportForm = true, goesToGuideForm = false)
            ),
            description = "",
            imageRes = R.drawable.problem200
        ),
        Dilemma(
            problemCode = "Problem_3",
            title = "Har du problemer med betalingen af din opladning?",
            contentTitle = "Vælg et af punkterne",
            questions = listOf(
                Question("Min FLEXCHARGE APP virker ikke?", "SupportForm", goesToSupportForm = true, goesToGuideForm = false),
                Question("Betalingen afvises?", "Problem_5", goesToSupportForm = false, goesToGuideForm = false),
                Question("Betalingen er godkendt, men opladningen starter ikke?", "SupportForm", goesToSupportForm = true, goesToGuideForm = false),
                Question("Jeg har et andet problem?", "SupportForm", goesToSupportForm = true, goesToGuideForm = false)
            ),
            description = "",
            imageRes = R.drawable.problem100
        ),
        Dilemma(
            problemCode = "Problem_5",
            title = "Betalingen afvises?",
            questions = listOf(

            ),
            description = "Vi har pt. ingen driftforstyrelser, så kontakt venligst din bank",
            contentTitle = "",
            imageRes = R.drawable.betling_afvist
        ),
        Dilemma(
            problemCode = "Problem_6",
            title = "El bilen melder fejl",
            questions = listOf(

            ),
            description = "Der er pt. ingen driftsforstyrelser, så kontakt venligst din elbilforhandler",
            contentTitle = "",
            imageRes = R.drawable.fail_car
        ),
    )

    fun getDilemmaByCode(problemCode: String): Dilemma {
        return dilemmas.firstOrNull { it.problemCode == problemCode }
            ?: dilemmas.first() // Fallback to the first dilemma if not found
    }

    // Function to determine the next route based on the selected question
    fun getNextRoute(currentProblemCode: String, questionText: String): String? {
        val currentDilemma = dilemmas.find { it.problemCode == currentProblemCode }
        val selectedQuestion = currentDilemma?.questions?.find { it.text == questionText }

        return selectedQuestion?.let {
            if (it.goesToSupportForm) {
                "SupportForm" // Navigate to the support form
            } else if (it.goesToGuideForm){
                "PaymentGuide"
            }
            else {
                it.nextProblemCode // Navigate to the next dilemma page
            }
        }
    }
}

