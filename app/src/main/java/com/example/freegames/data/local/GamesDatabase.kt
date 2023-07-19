package com.example.freegames.data.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
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
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d("GamesDatabase", "Database created")
                    }
                })
                .build()
        }
    }

    abstract fun gamesDao(): GamesDao
}