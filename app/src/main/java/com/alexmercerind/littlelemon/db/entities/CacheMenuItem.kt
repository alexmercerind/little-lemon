package com.alexmercerind.littlelemon.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache_menu_item")
data class CacheMenuItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)
