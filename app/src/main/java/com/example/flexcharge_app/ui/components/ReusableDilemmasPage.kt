package com.example.flexcharge_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flexcharge_app.R


@Composable
fun ReusableDilemmaPage(
    headerTitle: String,       // Title for the header
    contentTitle: String,      // Title for the content within the page
    questions: List<String>,
    imageRes: Int,
    onClicks: List<() -> Unit>,
    navController: NavController,
    startRoute: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        SimpleHeader(
            title = headerTitle,
            navController = navController,
            startRoute = startRoute
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Dilemma Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp)
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = contentTitle,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = description
        )

        Spacer(modifier = Modifier.height(16.dp))

        questions.forEachIndexed { index, questionText ->
            ButtonRow(
                text = questionText,
                horizontalPadding = 0.dp,
                onClick = onClicks.getOrElse(index) { {} }
            )
        }
    }
}

@Composable
fun ButtonRow(text: String, horizontalPadding: Dp, showArrow: Boolean = true, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = 8.dp)
            .height(56.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(start = 16.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f)
        )
        if (showArrow) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
