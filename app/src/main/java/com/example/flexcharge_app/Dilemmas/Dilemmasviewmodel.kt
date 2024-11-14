package com.example.flexcharge_app.Dilemmas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.flexcharge_app.models.Dilemma
import androidx.compose.material3.Text
import androidx.compose.material3.Button

class DilemmasViewModel : ViewModel() {

    val dilemma_new_customer = listOf(
        Dilemma(101 , "Hvordan får jeg installeret en ny laderstation?"),
        Dilemma(102 , "Hvordan bruger jeg betalings appen?"),
    )

    val dilemma_issues_with_charging = listOf(
        Dilemma(201 , "Elbilen melder fejl, hvad gør jeg?"),
        Dilemma(203, "Ladestationen lyser rød, hvad gør jeg?"),
        Dilemma(204 , "Jeg kan ikke få ladekablet ud af ladestationen?"),
        Dilemma(205, "Jeg har et andet problem")
    )

    val dilemma_issues_with_payment = listOf(
        Dilemma(301 , "Min FLEXCHARGE App. virker ikke?"),
        Dilemma(302, "Betalingen afvises?"),
        Dilemma(304 , "Betalingen er godkendt, men opladningen starter ikke?"),
        Dilemma(305 , "Jeg har et andet problem?")

    )

    val other_issues = listOf(
        Dilemma(401 , "Jeg har et andet problem")
    )
}

@Composable
fun DilemmaButtons(viewModel: DilemmasViewModel) {
    val messageState = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        viewModel.dilemma_new_customer.forEach { dilemma ->
            Button(onClick = { messageState.value = handleDilemmaClick(dilemma) }) {
                Text(text = dilemma.problem)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        // Display the message below the buttons
        if (messageState.value.isNotEmpty()) {
            Text(text = messageState.value, modifier = Modifier.padding(top = 16.dp))
        }
    }
}

fun handleDilemmaClick(dilemma: Dilemma): String {
    return when (dilemma.problemCode) {
        101 -> "Problem 101, så det er en ny kunde"
        201 -> "Problem 201, så der er fejl med elbilen"
        301 -> "Problem 301 , så appen virker ikke"
        401 -> "Problem 401, så et andet problem"
        else -> "Not really working"

    }

}