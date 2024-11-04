package com.example.flexcharge_app.ui.Problem300

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

const val Problem300_route = "Problem300"

@Composable
fun Problem300() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        Image(
            painter = painterResource(id = R.drawable.sorthvidbillede),
            contentDescription = "Billede",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Problemer med din betaling?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp)
                .align(Alignment.CenterHorizontally)
        )


        Text(
            text = "Vi sidder klar til at hjælpe med dit problem",
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
            "Min FLEXCHARGE App. virker ikke?",
            horizontalPadding = 0.dp,
            onClick = { /* kode 301*/ }
        )
        ButtonRow(
            "Betalingen afvises?",
            horizontalPadding = 0.dp,
            onClick = { /* kode 302 */ }
        )
        ButtonRow(
            "Betalingen er godkendt, men opladningen starter ikke?",
            horizontalPadding = 0.dp,
            onClick = { /* kode 303 */ }
        )
        ButtonRow(
            "Jeg har et andet problem?",
            horizontalPadding = 0.dp,
            onClick = { /*kode 304 */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProblem300() {
    FLEXCHARGEappTheme {
        Problem300()
    }
}
