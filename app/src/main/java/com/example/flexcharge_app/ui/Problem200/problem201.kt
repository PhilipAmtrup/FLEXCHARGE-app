package com.example.flexcharge_app.ui.Problem200

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val problem201_route = "Problem201"


@Preview
@Composable
fun problem201() {
    var phonenumber by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ){
        Text(
            text = "Problemer med ladestation",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))


        Text(
            "Vi har pt. driftsforstyrrelser, indtast venligst dit navn og telefonnummer, så en supporter kan ringe dig op indenfor 15 minutter. ",
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))


        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("Name") },
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = phonenumber,
            onValueChange = {phonenumber = it},
            label = { Text("Phone number") },
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }

}