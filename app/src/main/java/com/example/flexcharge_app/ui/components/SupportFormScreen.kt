package com.example.flexcharge_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // SimpleHeader for back navigation
        SimpleHeader(
            title = "Support Form",
            navController = navController,
            startRoute = startRoute
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image at the top
        Image(
            painter = painterResource(id = R.drawable.support_image), // Replace with your image resource
            contentDescription = "Support Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp)
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Indtast din email, telefon nummer og en beskrivelse af dit problem\n" +
                    "\nSå vil en salgsmedarbejder kontakte dig inden for få dage",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)

        )

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
            label = { Text("Phone Number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description Text Field
        OutlinedTextField(
            value = descriptionState.value,
            onValueChange = { descriptionState.value = it },
            label = { Text("Description of the Problem") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Submit Button

        Button(
            onClick = {
                val formData = SupportFormData(
                    email = emailState.value,
                    phoneNumber = phoneState.value,
                    problemDescription = descriptionState.value
                )

                // Send data til ViewModel
              //  viewModel.saveFormData(formData)

                // Angiv problemCode og problemDescription i ViewModel
                viewModel.saveProblemDetails("Error123", descriptionState.value)

                // Send confirmation email
                viewModel.sendConfirmationEmail(formData.email)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Send", fontSize = 18.sp)
        }
    }
}


