package com.alexmercerind.littlelemon.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.alexmercerind.littlelemon.repository.CacheMenuItemRepository

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CacheMenuItemRepository(application)

    suspend fun getMenu() = repository.getMenu()
}
