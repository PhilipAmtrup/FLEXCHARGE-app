import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flexcharge_app.ui.theme.FLEXCHARGEappTheme

const val Problem302_route = "Problem302"

@Composable
fun Problem302 (harDriftsforstyrrelse: Boolean = false) {
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Betalingen afvises?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (harDriftsforstyrrelse) {
            Text(
                text = "Vi har pt. driftsforstyrrelser, så indtast venligst dit telefonnummer, og en support vil ringe dig op indenfor 15 min.",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Telefonnummer") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            )
            Button(
                onClick = {
    
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Send")
            }
        } else {
            Text(
                text = "Der er pt. ingen driftsforstyrrelser, så kontakt venligst din bank.",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

    }
}

@Preview(showBackground = true, name = "Uden driftsforstyrrelser")
@Composable
fun PreviewPaymentIssueScreenNoOutage() {
    FLEXCHARGEappTheme {
        Problem302(harDriftsforstyrrelse = false)
    }
}

@Preview(showBackground = true, name = "Med driftsforstyrrelser")
@Composable
fun PreviewPaymentIssueScreenWithOutage() {
    FLEXCHARGEappTheme {
        Problem302(harDriftsforstyrrelse = true)
    }
}
