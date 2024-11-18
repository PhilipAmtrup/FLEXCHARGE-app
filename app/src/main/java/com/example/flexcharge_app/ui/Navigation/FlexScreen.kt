package com.example.flexcharge_app.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

interface FlexScreen {
    fun getRoute(): String
    @Composable
    fun Content(navController: NavController)
}