package com.example.flexcharge_app.data.repository

import com.example.flexcharge_app.data.api.EmailApi
import com.example.flexcharge_app.data.model.SupportFormData

class EmailRepository(private val api: EmailApi) {

    suspend fun saveForm(data: SupportFormData) {
        // Gem data lokalt eller send til backend
    }

    suspend fun sendEmail(email: String): Boolean {
        return api.sendConfirmationEmail(email)
    }
}
