package com.alexmercerind.littlelemon.api

import com.alexmercerind.littlelemon.api.dto.Menu
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

class LittleLemonService {
    companion object {
        const val GET_MENU_URL =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"

        private val lock = Any()

        @Volatile
        private var _instance: LittleLemonService? = null

        val instance
            get() = _instance ?: synchronized(lock) {
                _instance ?: LittleLemonService().also {
                    _instance = it
                }
            }
    }

    suspend fun getMenu() = try {
        client.get(GET_MENU_URL).body<Menu>()
    } catch (e: Throwable) {
        e.printStackTrace()
        null
    }

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
}
