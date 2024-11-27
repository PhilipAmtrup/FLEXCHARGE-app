package com.example.flexcharge_app.model.api

interface EmailService {
    suspend fun sendConfirmationEmail(email: String, problemCode: String, description: String): Boolean
}
