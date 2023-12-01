package com.alexmercerind.littlelemon.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.alexmercerind.littlelemon.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application)

    val firstName get() = repository.firstName
    val lastName get() = repository.lastName
    val email get() = repository.email

    suspend fun save(firstName: String, lastName: String, email: String) =
        repository.save(firstName, lastName, email)

    suspend fun clear() =
        repository.clear()
}
