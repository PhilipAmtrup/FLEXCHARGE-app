package com.example.flexcharge_app.ui.Problem200

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        TopBar("Problemer med ladestation")

        Text(
            text = "Har du problemer med din ladestation?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 28.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))





        Spacer(modifier = Modifier.height(16.dp))


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title : String) {
    TopAppBar(
        title = { Text(text = title , color = Color.Black) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.LightGray // sets the background color
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
