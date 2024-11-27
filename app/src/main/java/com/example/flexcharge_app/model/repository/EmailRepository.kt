package com.example.flexcharge_app.model.repository

import com.example.flexcharge_app.model.api.EmailApi
import com.example.flexcharge_app.model.api.EmailService


class EmailRepository(private val api: EmailService) {
    suspend fun sendEmail(email: String, problemCode: String, description: String): Boolean {
        return api.sendConfirmationEmail(email, problemCode, description)
    }
}
