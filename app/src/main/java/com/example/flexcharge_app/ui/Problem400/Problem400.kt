package com.example.flexcharge_app.ui.Problem400

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flexcharge_app.R
import com.example.flexcharge_app.ui.Forside.ButtonRow400
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
            text = "Jeg har et andet problem",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 20.dp)
                .align(Alignment.CenterHorizontally)
        )




        // Her bruger jeg ButtonRow400 med rotation af pile
        ButtonRow400(
            text = "Beskriv i korte træk hvad dit problem er, så bliver du kontaktet af en servicemedarbejder",
            horizontalPadding = 16.dp,
            rotateArrow = isExpanded,
            onClick = { isExpanded = !isExpanded }
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
