package com.example.freegames.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.freegames.data.model.GameDto
import com.example.freegames.data.local.dao.GamesDao

@Database(entities = [GameDto::class], version = 1)
abstract class GamesDatabase : RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean): GamesDatabase {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, GamesDatabase::class.java)
            } else {
                Room.databaseBuilder(context, GamesDatabase::class.java, "test_database.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun gamesDao(): GamesDao
}