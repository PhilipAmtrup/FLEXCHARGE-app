package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexcharge_app.data.repository.EmailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SupportFormViewModel(private val repository: EmailRepository) : ViewModel() {

    var problemCode: String = ""
    var description: String = ""

    // MutableStateFlow to hold validation or status messages
    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> get() = _statusMessage

    private fun saveProblemDetails(code: String, desc: String) {
        problemCode = code
        description = desc
        println("Saved problem details: code=$problemCode, description=$description")
    }

    fun validateAndSend(email: String, phoneNumber: String, problemDescription: String) {
        // Perform validation
        when {
            email.isBlank() -> _statusMessage.value = "Email cannot be empty."
            phoneNumber.isBlank() -> _statusMessage.value = "Phone number cannot be empty."
            problemDescription.isBlank() -> _statusMessage.value = "Problem description cannot be empty."
            else -> {
                // If validation passes, save problem details and send the email
                saveProblemDetails(problemCode, description)
                sendConfirmationEmail(email)
            }
        }
    }

    private fun sendConfirmationEmail(email: String) {
        println("ViewModel attempting to send email to: $email")
        viewModelScope.launch {
            val result = repository.sendEmail(email, problemCode, description)
            if (result) {
                _statusMessage.value = "Your support request was submitted successfully!"
            } else {
                _statusMessage.value = "Failed to submit your support request. Please try again."
            }
            println("Email sent result: $result")
        }
    }

    fun clearStatusMessage() {
        _statusMessage.value = null
    }
}
