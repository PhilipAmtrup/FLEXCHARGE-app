package com.example.flexcharge_app.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.flexcharge_app.R

@Composable
fun BottomBarWithLogo(modifier: Modifier = Modifier) {
    val color = Color(0xFF000000)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color) // Example background color
            .padding(16.dp), // Padding around the bar
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.flexcharge_logo),
            contentDescription = "Company Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp)
        )
    }
}
