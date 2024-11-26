package com.example.flexcharge_app.model.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class EmailApi(private val client: HttpClient = HttpClient()) {

    // Sends a confirmation email to the user with detailed information.
    suspend fun sendConfirmationEmail(userEmail: String, problemCode: String, description: String): Boolean {
        val apiKey = "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"
        val senderEmail = "emil012j2@gmail.com"
        println("Sending email to: $userEmail with problemCode: $problemCode and description: $description")
        return try {
            val response = client.post("https://api.brevo.com/v3/smtp/email") {
                header("api-key", apiKey)
                contentType(ContentType.Application.Json)
                setBody(
                    """
                    {
                        "sender": {"email": "$senderEmail"},
                        "to": [{"email": "$userEmail"}],
                        "subject": "Confirmation of Your Support Request",
                        "htmlContent": "${createHtmlContent(problemCode, description)}"
                    }
                    """.trimIndent()
                )
            }
            response.status == HttpStatusCode.Created
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    // Helper function to create the HTML content as a string
    private fun createHtmlContent(problemCode: String, description: String): String {
        return """
            <h1>Support Request Received</h1>
            <p>Thank you for reaching out to us. Below are the details of your request:</p>
            <ul>
                <li><strong>Error Code:</strong> $problemCode</li>
                <li><strong>Problem Description:</strong> $description</li>
            </ul>
            <p>Our support team will contact you shortly to resolve the issue.</p>
            <p>Best regards,<br>FLEXCHARGE Support Team</p>
        """.trimIndent().replace("\n", "")
    }
}
