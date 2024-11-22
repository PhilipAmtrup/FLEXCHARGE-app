package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flexcharge_app.data.model.SupportFormData
import com.example.flexcharge_app.data.repository.EmailRepository
import kotlinx.coroutines.launch

class SupportFormViewModel(private val repository: EmailRepository) : ViewModel() {

    fun saveFormData(data: SupportFormData) {
        viewModelScope.launch {
            repository.saveForm(data) // Gem data (lokalt eller backend)
        }
    }

    fun sendConfirmationEmail(email: String) {
        viewModelScope.launch {
            repository.sendEmail(email)
        }
    }
}
