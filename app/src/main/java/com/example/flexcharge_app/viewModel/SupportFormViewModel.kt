package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexcharge_app.data.model.SupportFormData
import com.example.flexcharge_app.data.repository.EmailRepository
import kotlinx.coroutines.launch

class SupportFormViewModel(private val repository: EmailRepository) : ViewModel() {

    var problemCode: String = ""
    var description: String = ""

    fun saveProblemDetails(code: String, desc: String) {
        problemCode = code
        description = desc
        println("Saved problem details: code=$problemCode, description=$description")
    }

    fun sendConfirmationEmail(email: String) {
        println("ViewModel attempting to send email to: $email")
        viewModelScope.launch {
            val result = repository.sendEmail(email, problemCode, description)
            println("Email sent result: $result")
        }
    }
}
