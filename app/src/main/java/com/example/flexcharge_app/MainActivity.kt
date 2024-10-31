package com.example.flexcharge_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flexcharge_app.ui.Forside.ForsideScreen
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

