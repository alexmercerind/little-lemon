package com.alexmercerind.littlelemon.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alexmercerind.littlelemon.db.entities.CacheMenuItem

@Dao
interface CacheMenuItemDao {
    @Insert
    suspend fun insert(cacheMenuItem: CacheMenuItem)

    @Query("SELECT * FROM cache_menu_item")
    suspend fun getAll(): List<CacheMenuItem>
}
