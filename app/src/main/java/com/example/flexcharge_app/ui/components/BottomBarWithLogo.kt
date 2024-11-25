package com.example.flexcharge_app.ui.components

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
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Gray) // Example background color
            .padding(16.dp), // Padding around the bar
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.flexcharge_logo), // Replace with your actual logo resource ID
            contentDescription = "Company Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp) // Adjust size as needed
        )
    }
}
