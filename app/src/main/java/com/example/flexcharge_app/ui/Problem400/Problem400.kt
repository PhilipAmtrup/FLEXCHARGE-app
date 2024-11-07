package com.example.flexcharge_app.ui.Problem300

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flexcharge_app.R
import com.example.flexcharge_app.ui.Forside.ButtonRow
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme

const val Problem400_route = "Problem400"

@Composable
fun Problem400() {

    var isExpanded by remember { mutableStateOf(false) } // Holder styr på om tekstfeltet er synligt
    var text by remember { mutableStateOf("") } // Holder på teksten fra tekstfeltet

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.new_customer),
            contentDescription = "Billede",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopEnd
        )

        Text(
            text = "Hvordan bruger jeg betalingsapp'en?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Hvordan kan vi hælpe?",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp,
                fontFamily = FontFamily.Default
            ),
            color = Color.DarkGray,
            modifier = Modifier
                .padding(top = 13.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Brug ButtonRow, men tilføj pilrotation specifikt i Problem400
        ButtonRow(
            text = "Beskriv i korte træk hvad dit problem er, så bliver du kontaktet af en servicemedarbejder",
            horizontalPadding = 16.dp,
            onClick = { isExpanded = !isExpanded }
        )

        // Tilføj den roterende pil ved siden af ButtonRow
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Expand/Collapse Arrow",
            modifier = Modifier
                .size(20.dp) // Juster pilens størrelse for bedre proportioner
                .graphicsLayer(rotationZ = if (isExpanded) 90f else 0f)
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp)
        )

        // Viser tekstfeltet, hvis `isExpanded` er sand
        if (isExpanded) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Skriv dit problem her") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProblem400() {
    FLEXCHARGEappTheme {
        Problem400()
    }
}
