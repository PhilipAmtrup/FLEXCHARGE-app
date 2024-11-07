package com.example.flexcharge_app.ui.Forside

import android.service.autofill.OnClickAction
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.flexcharge_app.R
import com.example.flexcharge_app.ui.Problem200.Problem200
import com.example.flexcharge_app.ui.Problem200.Problem200_route
import com.example.flexcharge_app.ui.Problem300.Problem300
import com.example.flexcharge_app.ui.Problem300.Problem300_route
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme



const val Forside_route = "forside"

@Composable
fun ForsideScreen(navController: NavController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

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
            text = "Info: Vælg et af punkterne",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
            color = Color.Black,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ButtonRow(
            "Er du ny kunde?",
            horizontalPadding = 0.dp ,
            onClick = {}
        )
        ButtonRow(
            "Har problemer med din ladestation?",
            horizontalPadding = 0.dp,
            onClick = {navController.navigate(Problem200_route)}
        )

        ButtonRow(
            "Har problemer med betaling af opladning?",
            horizontalPadding = 0.dp,
            onClick = {navController.navigate(Problem300_route)}
        )
        ButtonRow(
            "Har du andre problemer?",
            horizontalPadding = 0.dp,
            onClick = {}
        )
    }
}

@Composable
fun ButtonRow(text: String, horizontalPadding: Dp, showArrow: Boolean = true , onClick : () -> Unit) {
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
                painter = painterResource(id = R.drawable.button_arrow),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }

}
// Tilføjet en ekstra buttonrow så teksten passer bedre ind i boksen (sindsyg lang tekst :D)
@Composable
fun ButtonRow400(text: String, horizontalPadding: Dp, showArrow: Boolean = true, rotateArrow: Boolean = false, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = 8.dp)
            .height(80.dp) // Tilpasset højde til `Problem400` for mere plads til teksten
            .background(Color.White, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(start = 16.dp, end = 8.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp, // Reduceret tekststørrelse for at passe bedre
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f)
        )
        if (showArrow) {
            Icon(
                painter = painterResource(id = R.drawable.button_arrow),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .graphicsLayer(rotationZ = if (rotateArrow) 90f else 0f) // Tilføjet rotation baseret på `rotateArrow`
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForsideScreen() {
    FLEXCHARGEappTheme {
        ForsideScreen()
    }
}
