package com.alexmercerind.littlelemon.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    val menu: List<MenuItem>
)
