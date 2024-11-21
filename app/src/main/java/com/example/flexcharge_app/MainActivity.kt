package com.example.flexcharge_app

import Problem301
import Problem301_route
import Problem302
import Problem302_route
import Problem304
import Problem304_route
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flexcharge_app.ui.Forside.ForsideScreen
import com.example.flexcharge_app.ui.Forside.Forside_route
import com.example.flexcharge_app.ui.Problem200.Problem200
import com.example.flexcharge_app.ui.Problem200.Problem200_route
import com.example.flexcharge_app.ui.Problem300.Problem300
import com.example.flexcharge_app.ui.Problem300.Problem300_route
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flexcharge_app.ui.Problem200.problem201
import com.example.flexcharge_app.ui.Problem200.problem201_route
import com.example.flexcharge_app.ui.Problem300.Problem305
import com.example.flexcharge_app.ui.Problem300.Problem305_route


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
        var showBackButton by remember { mutableStateOf(false) }

        LaunchedEffect(navController) {
            navController.addOnDestinationChangedListener { _, destination, _ ->
                showBackButton = destination.route != Forside_route
            }
        }

        Scaffold(
            topBar = { TopBar(navController, showBackButton) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Forside_route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Forside_route) { ForsideScreen(navController) }
                composable(Problem200_route) { Problem200() }
                composable(Problem300_route) { Problem300(navController) }  // Sender navController til Problem300
                composable(Problem301_route) { Problem301() }  // Sender navController til Problem301
                composable(Problem302_route) { Problem302() }  // Bruger Problem302_route
                composable(Problem304_route) { Problem304() }  // Bruger Problem302_route
                composable(Problem305_route) { Problem305() }  // Bruger Problem302_route
                composable(problem201_route) { problem201() }
            }

        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController?, showBackButton: Boolean) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Support",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                if (showBackButton) {
                    Spacer(modifier = Modifier.weight(0.12f))
                }
            }
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController?.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreviewWithBackButton() {
    FLEXCHARGEappTheme {
        TopBar(navController = null, showBackButton = true)
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreviewWithoutBackButton() {
    FLEXCHARGEappTheme {
        TopBar(navController = null, showBackButton = false)
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
