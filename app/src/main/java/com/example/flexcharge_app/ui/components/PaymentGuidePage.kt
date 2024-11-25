package com.example.flexcharge_app.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flexcharge_app.R.drawable.*


data class ImageTextItem(val title: String, val images: List<Int>, val text: String)


@Composable
fun PaymentGuidePage(
    navController: NavController,
    startRoute: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
    val sampleItems = listOf(
        ImageTextItem(
            title = "Tilføj kreditkort",
            images = listOf(),
            text =  "\n" +
                    "\nFørste gang eCharge+ downloades, indtastes kreditkortoplysninger.\n" +
                    "\n" +
                    "Som ekstra sikkerhed vil man første gang der startes en opladning, blive bedt om at indtaste kreditkortoplysningerne igen.\n" +
                    "\n" +
                    "Der kan tilføjes følgende betalingsmetoder:\n" +
                    "\n" +
                    "* VISA\n" +
                    "* MasterCard\n" +
                    "* PayPal\n" +
                    "\nHusk også at indtaste navneoplysninger under ‘Billing address’"
        ),
        ImageTextItem(
            title = "",
            images = listOf(first1),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(first2),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(first3),
            text = ""
        ),
        ImageTextItem(
            title = "Vælg ladestation",
            images = listOf(),
            text =  "\n" +
                    "\nVælg ladestationen på kortet eller indtast ladestation ID nederst i søgefeltet.\n" +
                    "\n" +
                    "De ladestationer man senest har benyttet, kan let vælges under indtastningsfeltet.\n" +
                    "\n" +
                    "Tryk Retur og gå nu til betaling med Prepare Charging.\n" +
                    "\n" +
                    "Check gerne prisen på opladningen, som ejeren af ladestationen modtager i betaling."
        ),
        ImageTextItem(
            title = "",
            images = listOf(second1),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(second2),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(second3),
            text = ""
        ),
        ImageTextItem(
            title = "Vælg og godkend betaling",
            images = listOf(),
            text =  "\n" +
                    "\nVælg eller se valgte betalingsmetode.\n" +
                    "\n" +
                    "Der bliver reserveret et beløb på 450 DKK. indtil opladningen er afsluttet.\n" +
                    "\n" +
                    "Ved afsluttet opladning, afregnes naturligvis kun for den faktisk opladning pr. kWh og evt. betalingsgebyr.\n" +
                    "\n" +
                    "Tryk Charge and pay når opladningen skal startes.\n" +
                    "\n" +
                    "Der er krav om 3D secure verficerings af betalinger og derfor skal der godkendes med NemID."
        ),
        ImageTextItem(
            title = "",
            images = listOf(third1),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(third2),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(third3),
            text = ""
        ),
        ImageTextItem(
            title = "Afslut Opladning",
            images = listOf(),
            text =  "\n" +
                    "\nNår batteriet er fyldt op eller opladningen skal afsluttes, kan man på eCharge+ app’en se hvor meget der er opladet og hvad det har kostet.\n" +
                    "\n" +
                    "Tryk på End charging.\n" +
                    "\n" +
                    "Kvitteringer for tidligere opladninger kan vises under View Charge History."
        ),
        ImageTextItem(
            title = "",
            images = listOf(fourth1),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(fourth2),
            text = ""
        ),
        ImageTextItem(
            title = "",
            images = listOf(fourth3),
            text = ""
        ),
    )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // Reserve space for the bottom bar
        ) {
            // Header
            SimpleHeader(
                title = "Hvordan bruger jeg betalings app'en?",
                navController = navController,
                startRoute = startRoute
            )

            // Content
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(sampleItems) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp) // Add vertical spacing between items
                    ) {
                        // Center the row of images
                        Row(
                            modifier = Modifier
                                .align(Alignment.Center) // Align the Row to the center of the parent Box
                                .horizontalScroll(rememberScrollState()),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            item.images.forEach { imageRes ->
                                Image(
                                    painter = painterResource(id = imageRes),
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit, // Ensures the full image is shown
                                    modifier = Modifier
                                        .fillMaxWidth() // Image fills the width of the screen
                                        .aspectRatio(16f / 9f) // Maintain a 16:9 aspect ratio
                                        .padding(vertical = 8.dp)
                                )
                            }
                        }
                        // Title for the section
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontSize = 24.sp,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Add text below the images
                        Text(
                            text = item.text,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.BottomStart) // Ensure the text is placed correctly
                        )
                    }
                }
            }
        }

        // Fixed Bottom Bar
        BottomBarWithLogo(
            modifier = Modifier
                .align(Alignment.BottomCenter) // Keep the bottom bar fixed at the bottom
        )
    }
}

