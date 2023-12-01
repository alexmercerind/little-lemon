package com.alexmercerind.littlelemon.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexmercerind.littlelemon.db.entities.CacheMenuItem

@Database(entities = [CacheMenuItem::class], version = 1)
abstract class CacheMenuItemDatabase : RoomDatabase() {
    abstract fun cacheMenuItemDao(): CacheMenuItemDao

    companion object {

        private val lock = Any()

        @Volatile
        private var instance: CacheMenuItemDatabase? = null

        operator fun invoke(application: Application) = instance ?: synchronized(lock) {
            instance ?: Room.databaseBuilder(
                application,
                CacheMenuItemDatabase::class.java,
                "cache-menu-item-database"
            ).build().also {
                instance = it
            }
        }
    }
}
