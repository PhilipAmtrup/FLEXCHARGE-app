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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))

    ) {

    // Listen to status messages from ViewModel
    val statusMessage by viewModel.statusMessage.collectAsState()

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
                .padding(horizontal = 0.dp)
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

        // Email Text Field
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email Address:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Phone Number Text Field
        OutlinedTextField(
            value = phoneState.value,
            onValueChange = { phoneState.value = it },
            label = { Text("Mobil:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description Text Field
        OutlinedTextField(
            value = descriptionState.value,
            onValueChange = { descriptionState.value = it },
            label = { Text("Beskriv dit problem:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            maxLines = 10
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
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Send")
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
        // Fixed Bottom Bar
        BottomBarWithLogo(
            modifier = Modifier
                .align(Alignment.BottomCenter) // This ensures the bar is fixed at the bottom
        )
    }
}


