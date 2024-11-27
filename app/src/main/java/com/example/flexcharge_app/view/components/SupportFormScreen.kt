package com.example.flexcharge_app.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flexcharge_app.R
import com.example.flexcharge_app.viewModel.SupportFormViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay


@Composable
fun SupportFormScreen(
    navController: NavController,
    startRoute: String,
    viewModel: SupportFormViewModel,
    errorCode: String
) {
    val coroutineScope = rememberCoroutineScope()  // Remember a CoroutineScope
    // States for each text field
    val emailState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }
    val statusMessage by viewModel.statusMessage.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Enable scrolling
            .imePadding() // Add padding to adjust for the keyboard
            .background(Color(0xFFF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {
            // Header
            SimpleHeader(
                title = "Support",
                navController = navController,
                startRoute = startRoute
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Image at the top
            Image(
                painter = painterResource(id = R.drawable.support_image),
                contentDescription = "Support Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Indtast din email, mobilnummer og en beskrivelse af dit problem\n" +
                        "\nSå vil vi kontakte dig angående dit problem/forespørgsel",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email Text Field
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Phone Number Text Field
            OutlinedTextField(
                value = phoneState.value,
                onValueChange = { phoneState.value = it },
                label = { Text("Mobil") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Description Text Field
            OutlinedTextField(
                value = descriptionState.value,
                onValueChange = { descriptionState.value = it },
                label = { Text("Beskriv dit problem") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                maxLines = 10
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                    coroutineScope.launch {
                        // Save the errorCode in the ViewModel
                        viewModel.saveProblemDetails(errorCode, descriptionState.value)

                        // Validate and send the email
                        viewModel.validateAndSend(
                            emailState.value,
                            phoneState.value,
                            descriptionState.value
                        )
                        // Clear text fields after sending a support form

                        delay(1500)
                        emailState.value = ""
                        phoneState.value = ""
                        descriptionState.value = ""
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Send")
            }
        }

        statusMessage?.let { message ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                Snackbar(
                    action = {
                        TextButton(onClick = { viewModel.clearStatusMessage() }) {
                            Text("OK")
                        }
                    }
                ) {
                    Text(message)
                }
            }
        }
    }
}
