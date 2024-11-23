package com.example.flexcharge_app
import com.example.flexcharge_app.data.api.EmailApi
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class EmailApiTest {
/*
Den nuværende test tjekker, om funktionen sendConfirmationEmail gør følgende korrekt:
//Sender en e-mail med de rigtige oplysninger (f.eks. email, problemkode, og beskrivelse).
Får det rigtige svar fra serveren:
 */
    @Test
    fun `test sendConfirmationEmail success`() = runBlocking {
        val mockEngine = MockEngine { request ->
            // Returner en mock-respons med 201 Created
            respond(
                content = """{"success": true}""",
                status = HttpStatusCode.Created,
                headers = headersOf("Content-Type" to listOf("application/json"))
            )
        }

        // Opret en HttpClient med MockEngine
        val client = HttpClient(mockEngine)
        val emailApi = EmailApi(client) // Brug mock-klienten her

        // Test funktionen
        val result = emailApi.sendConfirmationEmail(
            userEmail = "test@example.com",
            problemCode = "123",
            description = "Test issue description"
        )

        // Valider resultatet
        assertEquals(true, result)
    }

    @Test
    fun `test sendConfirmationEmail failure`() = runBlocking {
        val mockEngine = MockEngine { request ->
            // Returner en mock-respons med 401 Unauthorized
            respond(
                content = """{"success": false}""",
                status = HttpStatusCode.Unauthorized,
                headers = headersOf("Content-Type" to listOf("application/json"))
            )
        }

        // Opret en HttpClient med MockEngine
        val client = HttpClient(mockEngine)
        val emailApi = EmailApi(client) // Brug mock-klienten her

        // Test funktionen
        val result = emailApi.sendConfirmationEmail(
            userEmail = "test@example.com",
            problemCode = "123",
            description = "Test issue description"
        )

        // Valider resultatet
        assertEquals(false, result)
    }
}
