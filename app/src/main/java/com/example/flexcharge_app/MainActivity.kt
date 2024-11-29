package com.example.flexcharge_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.flexcharge_app.view.navigation.NavigationComponent
import com.example.flexcharge_app.viewModel.DilemmasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlexChargeApp()
        }
    }
}

@Composable
fun FlexChargeApp() {
    val navController = rememberNavController()
    val viewModel: DilemmasViewModel = viewModel()

    NavigationComponent(navController = navController, viewModel = viewModel)
}
