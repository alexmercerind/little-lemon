package com.alexmercerind.littlelemon.repository

import android.app.Application
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserRepository(application: Application) {
    val firstName: StateFlow<String>
        get() = _firstName
    private val _firstName = MutableStateFlow<String>("")

    val lastName: StateFlow<String>
        get() = _lastName
    private val _lastName = MutableStateFlow<String>("")

    val email: StateFlow<String>
        get() = _email
    private val _email = MutableStateFlow<String>("")

    private val sharedPreferences = application.getSharedPreferences(
        "little-lemon", Context.MODE_PRIVATE
    )

    val isLogged: Boolean
        get() = sharedPreferences.contains(FIRST_NAME_KEY) &&
                sharedPreferences.contains(LAST_NAME_KEY) &&
                sharedPreferences.contains(EMAIL_KEY)

    init {
        GlobalScope.launch(Dispatchers.IO) {
            _firstName.emit(sharedPreferences.getString(FIRST_NAME_KEY, "")!!)
            _lastName.emit(sharedPreferences.getString(LAST_NAME_KEY, "")!!)
            _email.emit(sharedPreferences.getString(EMAIL_KEY, "")!!)
        }
    }

    suspend fun save(firstName: String, lastName: String, email: String) {
        _firstName.emit(firstName)
        _lastName.emit(lastName)
        _email.emit(email)

        sharedPreferences.edit()
            .putString(FIRST_NAME_KEY, firstName)
            .putString(LAST_NAME_KEY, lastName)
            .putString(EMAIL_KEY, email)
            .apply()
    }

    suspend fun clear() {
        _firstName.emit("")
        _lastName.emit("")
        _email.emit("")

        sharedPreferences.edit()
            .remove(FIRST_NAME_KEY)
            .remove(LAST_NAME_KEY)
            .remove(EMAIL_KEY)
            .apply()
    }

    companion object {
        private const val FIRST_NAME_KEY = "FIRST_NAME"
        private const val LAST_NAME_KEY = "LAST_NAME"
        private const val EMAIL_KEY = "EMAIL"

        private val lock = Any()

        @Volatile
        private var instance: UserRepository? = null

        operator fun invoke(application: Application) = instance ?: synchronized(lock) {
            instance ?: UserRepository(application).also { instance = it }
        }
    }
}
