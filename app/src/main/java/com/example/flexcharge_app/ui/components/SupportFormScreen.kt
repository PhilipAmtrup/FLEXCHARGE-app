package com.example.flexcharge_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flexcharge_app.R
import com.example.flexcharge_app.data.model.SupportFormData
import com.example.flexcharge_app.viewModel.SupportFormViewModel


@Composable
fun SupportFormScreen(
    navController: NavController,
    startRoute: String,
    viewModel: SupportFormViewModel
) {
    // States for each text field
    val emailState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }

    // Listen to status messages from ViewModel
    val statusMessage by viewModel.statusMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        SimpleHeader(
            title = "Support Form",
            navController = navController,
            startRoute = startRoute
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Text Field
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Phone Text Field
        OutlinedTextField(
            value = phoneState.value,
            onValueChange = { phoneState.value = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description Text Field
        OutlinedTextField(
            value = descriptionState.value,
            onValueChange = { descriptionState.value = it },
            label = { Text("Problem Description") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(
            onClick = {
                viewModel.validateAndSend(
                    emailState.value,
                    phoneState.value,
                    descriptionState.value
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        // Snackbar for status message
        statusMessage?.let { message ->
            Snackbar(
                action = {
                    TextButton(onClick = { viewModel.clearStatusMessage() }) {
                        Text("Dismiss")
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(message)
            }
        }
    }
}


