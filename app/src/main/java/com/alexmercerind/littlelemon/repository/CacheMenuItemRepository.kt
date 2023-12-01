package com.alexmercerind.littlelemon.repository

import android.app.Application
import com.alexmercerind.littlelemon.api.LittleLemonService
import com.alexmercerind.littlelemon.db.CacheMenuItemDatabase
import com.alexmercerind.littlelemon.db.entities.CacheMenuItem
import toCacheMenuItem

class CacheMenuItemRepository(private val application: Application) {
    suspend fun getMenu(): List<CacheMenuItem>? {
        val dao = CacheMenuItemDatabase(application).cacheMenuItemDao()
        // Cache
        val cache = dao.getAll()
        // Cache: Empty
        if (cache.isEmpty()) {
            // API Request
            val response = LittleLemonService.instance.getMenu()
            if (response != null) {
                // Cache: Insert
                for (menuItem in response.menu) {
                    dao.insert(menuItem.toCacheMenuItem())
                }
                return response.menu.map { it.toCacheMenuItem() }
            }
            return null
        }
        // Cache: Available
        else {
            return cache
        }
    }
}
