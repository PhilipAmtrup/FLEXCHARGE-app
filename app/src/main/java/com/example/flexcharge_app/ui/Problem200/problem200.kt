package com.example.flexcharge_app.ui.Problem200

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flexcharge_app.R
import com.example.flexcharge_app.ui.Forside.ButtonRow
import com.example.flexcharge_app.ui.Forside.ForsideScreen
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme

@Composable
fun Problem200() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(vertical = 16.dp)
    ) {
        TopBar("Problemer med ladestationen")

        Text(
            text = "Har du problemer med din ladestation?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 28.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Fortæl os nærmere om problemerne ved ladestanderen",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 22.sp,
                fontFamily = FontFamily.Default
            ),
            color = Color.DarkGray,
            modifier = Modifier
                .padding(top = 13.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )






        Spacer(modifier = Modifier.height(16.dp))

        ButtonRow("Elbilen melder fejl, hvad gør jeg?", horizontalPadding = 0.dp)
        ButtonRow("Ladestationen lyser rød, hvad gør jeg?", horizontalPadding = 0.dp)
        ButtonRow("Jeg kan ikke få ladekablet ud ladestationen...", horizontalPadding = 0.dp)
        ButtonRow("Jeg har et andet problem...", horizontalPadding = 0.dp)

    }
}

private val oliveGreen = Color(0xFF808000)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title : String) {

    TopAppBar(
        title = { Text(text = title , color = Color.Black) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    Color = Color.Black
                )
            }
        },


        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = oliveGreen // sets the background color
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProblem200() {
    FLEXCHARGEappTheme {
        Problem200()
    }
}