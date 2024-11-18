package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import com.example.flexcharge_app.R

data class Dilemma(
    val problemCode: String,
    val title: String,
    val questions: List<Question>,
    val imageRes: Int
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
            title = "Vælg et af punkterne",
            questions = listOf(
                Question("Er du ny kunde?", "Problem_1"),
                Question("Har du problemer med din ladestation?", "Problem_2"),
                Question("Har du problemer med betalingen af din opladning?", "Problem_3"),
                Question("Har du andre problemer?", "Problem_4")
            ),
            imageRes = R.drawable.flexcharger_image
        ),
        Dilemma(
            problemCode = "Problem_1",
            title = "New Customer Information",
            questions = listOf(
                Question("Learn about getting started", null),
                Question("Contact support", null)
            ),
            imageRes = R.drawable.problem300
        ),
        Dilemma(
            problemCode = "Problem_2",
            title = "Problemer med ladestation\n Vælg et af punkterne",
            questions = listOf(
                Question("Elbilen melder fejl, hvad gør jeg?", null),
                Question("Ladestationen lyser rød, hvad gør jeg?", null),
                Question("Jeg kan ikke få ladekablet ud af ladestation", null),
                Question("Jeg har et andet problem", null)
            ),
            imageRes = R.drawable.problem200
        ),
        Dilemma(
            problemCode = "Problem_3",
            title = "Problemer med din betaling\n Vælg et af punkterne",
            questions = listOf(
                Question("Min FLEXCHARGE APP virker ikke?", null),
                Question("Betalingen afvises?", null),
                Question("Betalingen er godkendt, men opladningen starter ikke?", null),
                Question("Jeg har et andet problem?", null)
            ),
            imageRes = R.drawable.problem100
        ),
        Dilemma(
            problemCode = "Problem_4",
            title = "Other Issues",
            questions = listOf(
                Question("View FAQs", null),
                Question("Reach out for help", null)
            ),
            imageRes = R.drawable.problem400
        )
    )

    fun getDilemmaByCode(problemCode: String): Dilemma {
        return dilemmas.firstOrNull { it.problemCode == problemCode }
            ?: dilemmas.first() // Fallback to the first dilemma if not found
    }
}
