package com.example.flexcharge_app

import com.example.flexcharge_app.data.api.EmailApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.toByteArray
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class EmailApiTest {
    /*
    This class contains unit tests for the EmailApi class, which sends confirmation emails with problem details.
    Each test verifies different aspects of the email-sending functionality.
    */

    @Test
    fun `test sendConfirmationEmail success`() = runBlocking {
        // Test to ensure the email is sent successfully when the server responds with a 201 Created status.
        val mockEngine = MockEngine { request ->
            respond(
                content = """{"success": true}""",
                status = HttpStatusCode.Created,
                headers = headersOf("Content-Type" to listOf("application/json"))
            )
        }

        val client = HttpClient(mockEngine)
        val emailApi = EmailApi(client)

        val result = emailApi.sendConfirmationEmail(
            userEmail = "test@example.com",
            problemCode = "123",
            description = "Test issue description"
        )

        // Expect the result to be true, indicating success.
        assertEquals(true, result)
    }

    @Test
    fun `test sendConfirmationEmail failure`() = runBlocking {
        // Test to ensure the email fails to send when the server responds with a 401 Unauthorized status.
        val mockEngine = MockEngine { request ->
            respond(
                content = """{"success": false}""",
                status = HttpStatusCode.Unauthorized,
                headers = headersOf("Content-Type" to listOf("application/json"))
            )
        }

        val client = HttpClient(mockEngine)
        val emailApi = EmailApi(client)

        val result = emailApi.sendConfirmationEmail(
            userEmail = "test@example.com",
            problemCode = "123",
            description = "Test issue description"
        )

        // Expect the result to be false, indicating failure.
        assertEquals(false, result)
    }

    @Test
    fun `test sendConfirmationEmail includes correct details`() = runBlocking {
        // Test to verify that the email payload includes the correct user email, problem code, and description.
        val mockEngine = MockEngine { request ->
            val body = request.body.toByteArray().toString(Charsets.UTF_8)

            // Assert the payload contains the expected values.
            assert(body.contains("test@example.com"))
            assert(body.contains("123")) // Problem Code
            assert(body.contains("Test issue description")) // Description

            respond(
                content = """{"success": true}""",
                status = HttpStatusCode.Created,
                headers = headersOf("Content-Type" to listOf("application/json"))
            )
        }

        val client = HttpClient(mockEngine)
        val emailApi = EmailApi(client)

        val result = emailApi.sendConfirmationEmail(
            userEmail = "test@example.com",
            problemCode = "123",
            description = "Test issue description"
        )

        // Expect the result to be true, indicating success.
        assertEquals(true, result)
    }
}
