package com.example.flexcharge_app.data.repository

import com.example.flexcharge_app.data.api.EmailApi


class EmailRepository(private val api: EmailApi) {
    suspend fun sendEmail(email: String, problemCode: String, description: String): Boolean {
        return api.sendConfirmationEmail(email, problemCode, description)
    }
}
