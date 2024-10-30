package com.example.flexcharge_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.flexcharge_app.Dilemmas.DilemmaButtons
import com.example.flexcharge_app.Dilemmas.DilemmasViewModel
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FLEXCHARGEappTheme {
                ForsideScreen()
            }
        }
    }
}

@Composable
fun ForsideScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Support",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 28.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.flexcharger_image),
            contentDescription = "Flexcharge Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp)
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Har du brug for hjælp?",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ButtonRow("Er du ny kunde?", horizontalPadding = 0.dp)
        ButtonRow("Har problemer med din ladestation?", horizontalPadding = 0.dp)
        ButtonRow("Har problemer med betaling af opladning?", horizontalPadding = 0.dp)
        ButtonRow("Har du andre problemer?", horizontalPadding = 0.dp)
    }
}

@Composable
fun ButtonRow(text: String, horizontalPadding: Dp) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = 8.dp)
            .height(56.dp),
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForsideScreen() {
    FLEXCHARGEappTheme {
        ForsideScreen()
    }
}
