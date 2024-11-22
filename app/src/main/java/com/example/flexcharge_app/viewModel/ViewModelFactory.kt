package com.example.flexcharge_app.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flexcharge_app.data.repository.EmailRepository

class SupportFormViewModelFactory(
    private val repository: EmailRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SupportFormViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SupportFormViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
