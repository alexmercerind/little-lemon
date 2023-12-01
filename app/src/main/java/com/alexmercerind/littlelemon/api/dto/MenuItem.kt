package com.alexmercerind.littlelemon.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)
