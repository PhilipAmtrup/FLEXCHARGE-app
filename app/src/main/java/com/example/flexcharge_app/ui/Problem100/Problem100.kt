package com.example.flexcharge_app.ui.Problem100

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flexcharge_app.R
import com.example.flexcharge_app.ui.Forside.ButtonRow
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme

const val Problem100_route = "Problem100"

@Composable
fun Problem100() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
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
            text = "Er du ny kunde?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = Color.Black,
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



        ButtonRow(
            "Hvordan får jeg installeret en ny laderstation?",
            horizontalPadding = 0.dp,
            onClick = { /* kode 101*/ }
        )
        ButtonRow(
            "Hvordan bruger jeg betalingsapp'en?",
            horizontalPadding = 0.dp,
            onClick = { /* kode 102 */ }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProblem100() {
    FLEXCHARGEappTheme {
        Problem100()
    }
}
