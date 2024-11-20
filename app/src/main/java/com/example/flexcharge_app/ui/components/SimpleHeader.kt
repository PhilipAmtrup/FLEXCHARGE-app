package com.example.flexcharge_app.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flexcharge_app.R

@Composable
fun SimpleHeader(
    title: String,
    navController: NavController,
    startRoute: String
) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val showBackButton = currentBackStackEntry.value?.destination?.route != startRoute

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp), // Consistent padding on all sides
        verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
    ) {
        if (showBackButton) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp)) // Space between the back button and the title

        Text(
            text = title,
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge, // Ensuring it uses consistent typography
            modifier = Modifier
                .weight(1f) // Take the remaining space to ensure proper alignment
                .padding(start = if (showBackButton) 8.dp else 8.dp)
        )
    }
}
