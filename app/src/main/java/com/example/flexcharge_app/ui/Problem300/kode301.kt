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

const val Problem301_route = "Problem301"

@Composable
fun Problem301() {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var issueDescription by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Min FLEXCHARGE APP virker ikke?",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Udfyld venligst felterne nedenfor, og der bliver oprettet en sag. Status kan følges på vores website under 'drift'.",
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 14.sp),
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Navn") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = issueDescription,
            onValueChange = { issueDescription = it },
            label = { Text("Beskrivelse af problem") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                // Her kan du tilføje logik til at håndtere indsendelse af data
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Indsend")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProblem301() {
    FLEXCHARGEappTheme {
        Problem301()
    }
}
