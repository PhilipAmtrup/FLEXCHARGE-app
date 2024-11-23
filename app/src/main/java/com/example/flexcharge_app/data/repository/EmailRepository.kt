package com.example.flexcharge_app.data.repository

import com.example.flexcharge_app.data.api.EmailApi
import com.example.flexcharge_app.data.model.SupportFormData

class EmailRepository(private val api: EmailApi) {

    suspend fun sendEmail(email: String, problemCode: String, description: String): Boolean {
        println("Repository sending email to $email with code: $problemCode and description: $description")
        return api.sendConfirmationEmail(email, problemCode, description)
    }
}
