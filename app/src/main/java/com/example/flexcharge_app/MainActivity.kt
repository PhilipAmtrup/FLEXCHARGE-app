package com.example.flexcharge_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flexcharge_app.ui.Forside.ButtonRow
import com.example.flexcharge_app.ui.Forside.ForsideScreen
import com.example.flexcharge_app.ui.Forside.Forside_route
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flexcharge_app.ui.Problem200.Problem200
import com.example.flexcharge_app.ui.Problem200.Problem200_route
import com.example.flexcharge_app.ui.Problem300.Problem300
import com.example.flexcharge_app.ui.Problem300.Problem300_route


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FLEXCHARGEappTheme {
                FlexChargeApp()
            }
        }
    }
}

@Composable
fun FlexChargeApp() {
    FLEXCHARGEappTheme {
        val navController = rememberNavController()

        Scaffold(
            topBar = { TopBar(navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Forside_route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Forside_route) { ForsideScreen(navController) }
                composable(Problem200_route) { Problem200() }
                composable(Problem300_route) { Problem300() }
            }
        }
    }
}

/*
@Composable
fun FlexChargeApp() {
    FLEXCHARGEappTheme {

        Scaffold(
            topBar = {

            }
        )

    }

}


fun TopBar() {

}
*/

private val oliveGreen = Color(0xFF808000)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController:   NavController) {
    TopAppBar(
        title = { Text("Support") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}
