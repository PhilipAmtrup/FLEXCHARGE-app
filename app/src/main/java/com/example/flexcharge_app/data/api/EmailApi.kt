package com.example.flexcharge_app.data.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class EmailApi {
    private val client = HttpClient()

    suspend fun sendConfirmationEmail(userEmail: String): Boolean {
        val apiKey = "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"
        val senderEmail = "emil012j2@gmail.com"

        return try {
            val response = client.post("https://api.brevo.com/v3/smtp/email") {
                header("api-key", apiKey)
                contentType(ContentType.Application.Json)
                setBody(
                    """
                    {
                        "sender": {"email": "$senderEmail"},
                        "to": [{"email": "$userEmail"}],
                        "subject": "Support Confirmation",
                        "htmlContent": "<p>Thank you for contacting us.</p>"
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
}
