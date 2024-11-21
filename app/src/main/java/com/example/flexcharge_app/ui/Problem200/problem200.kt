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
import androidx.compose.ui.layout.Remeasurement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flexcharge_app.R
import com.example.flexcharge_app.ui.Forside.ButtonRow
import com.example.flexcharge_app.ui.Forside.ForsideScreen
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme

const val Problem200_route = "Problem200"


@Composable
fun Problem200(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(vertical = 16.dp)
    ) {

        Text(
            text = "Problemer med ladestation",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(30.dp))


        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Fortæl os nærmere om problemet ved ladestanderen",
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



        Spacer(modifier = Modifier.height(16.dp))

        ButtonRow(
            "Elbilen melder fejl, hvad gør jeg?",
            horizontalPadding = 0.dp ,
            onClick = {navController.navigate(problem201_route)}
        )
        ButtonRow("Ladestationen lyser rød, hvad gør jeg?",
            horizontalPadding = 0.dp,
            onClick = {}
        )
        ButtonRow(
            "Jeg kan ikke få ladekablet ud ladestationen...",
            horizontalPadding = 0.dp,
            onClick = {}
        )
        ButtonRow(
            "Jeg har et andet problem...",
            horizontalPadding = 0.dp,
            onClick = {}
        )

    }
}

private val oliveGreen = Color(0xFF808000)


@Preview(showBackground = true)
@Composable
fun PreviewProblem200() {
    FLEXCHARGEappTheme {
        Problem200()
    }
}
