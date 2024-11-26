package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexcharge_app.data.repository.EmailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SupportFormViewModel(private val repository: EmailRepository) : ViewModel() {

    var errorCode: String = ""
    var description: String = ""

    // StateFlow for status messages
    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> get() = _statusMessage

    fun saveProblemDetails(code: String, desc: String) {
        errorCode = code
        description = desc
        println("Saved problem details: code=$errorCode, description=$description")
    }

    fun validateAndSend(email: String, phoneNumber: String, problemDescription: String) {
        when {
            email.isBlank() -> _statusMessage.value = "Email cannot be empty."
            phoneNumber.isBlank() -> _statusMessage.value = "Phone number cannot be empty."
            problemDescription.isBlank() -> _statusMessage.value = "Problem description cannot be empty."
            else -> {
                viewModelScope.launch {
                    val result = repository.sendEmail(email, errorCode, problemDescription)
                    _statusMessage.value = if (result) {
                        "Your support request was submitted successfully!"
                    } else {
                        "Failed to submit your support request. Please try again."
                    }
                }
            }
        }
    }

    fun clearStatusMessage() {
        _statusMessage.value = null
    }
}
