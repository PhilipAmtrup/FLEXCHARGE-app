package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import com.example.flexcharge_app.R

data class Dilemma(
    val problemCode: String,
    val title: String,
    val questions: List<Question>,
    val imageRes: Int,
    val description: String
)

data class Question(
    val text: String,
    val nextProblemCode: String? // The code of the next problem, null if there is no next
)

class DilemmasViewModel : ViewModel() {

    // Define all dilemmas with their unique problemCodes
    val dilemmas = listOf(
        Dilemma(
            problemCode = "Problem_0",
            title = "FLEXCHARGE App",
            questions = listOf(
                Question("Er du ny kunde?", "Problem_1"),
                Question("Har du problemer med din ladestation?", "Problem_2"),
                Question("Har du problemer med betalingen af din opladning?", "Problem_3"),
                Question("Har du andre problemer?", "Problem_4")
            ),
            description = "",
            imageRes = R.drawable.flexcharger_image
        ),
        Dilemma(
            problemCode = "Problem_1",
            title = "Er du ny kunde?",
            questions = listOf(
                Question("Hvordan får jeg installeret en ny laderstation?", "Problem_5"),
                Question("Hvordan bruger jeg betalings app'en?", "Problem 6")
            ),
            description = "",
            imageRes = R.drawable.problem300
        ),
        Dilemma(
            problemCode = "Problem_2",
            title = "Har du problemer med din ladestation?",
            questions = listOf(
                Question("Elbilen melder fejl, hvad gør jeg?", "Problem_6"),
                Question("Ladestationen lyser rød, hvad gør jeg?", null),
                Question("Jeg kan ikke få ladekablet ud af ladestation", null),
                Question("Jeg har et andet problem", null)
            ),
            description = "",
            imageRes = R.drawable.problem200
        ),
        Dilemma(
            problemCode = "Problem_3",
            title = "Har du problemer med betalingen af din opladning?",
            questions = listOf(
                Question("Min FLEXCHARGE APP virker ikke?", null),
                Question("Betalingen afvises?", null),
                Question("Betalingen er godkendt, men opladningen starter ikke?", null),
                Question("Jeg har et andet problem?", null)
            ),
            description = "",
            imageRes = R.drawable.problem100
        ),
        Dilemma(
            problemCode = "Problem_4",
            title = "Har du andre problemer?",
            questions = listOf(
                Question("", null),
                Question("Reach out for help", null)
            ),
            description = "",
            imageRes = R.drawable.problem400
        ),
        Dilemma(
            problemCode = "Problem_5",
            title = "Skal være en tekst beskrivelse her",
            questions = listOf(

            ),
            description = "",
            imageRes = R.drawable.flexcharger_image
        ),
        Dilemma(
            problemCode = "Problem_6",
            title = "El bilen melder fejl",
            questions = listOf(

            ),
            description = "Der er pt. ingen driftsforstyrelser, så kontakt venligst din elbilforhandler",
            imageRes = R.drawable.flexcharger_image
        ),
        Dilemma(
            problemCode = "Problem_7",
            title = "",
            questions = listOf(

            ),
            description = "",
            imageRes = R.drawable.flexcharger_image
        ),
    )

    fun getDilemmaByCode(problemCode: String): Dilemma {
        return dilemmas.firstOrNull { it.problemCode == problemCode }
            ?: dilemmas.first() // Fallback to the first dilemma if not found
    }
}
