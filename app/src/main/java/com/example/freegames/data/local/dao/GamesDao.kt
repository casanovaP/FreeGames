package com.example.freegames.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.freegames.data.model.GameDto

@Dao
interface GamesDao {
    @Query("SELECT * FROM game_table ORDER BY id ASC")
    fun getAllGames(): List<GameDto>

    @Query("SELECT * FROM game_table WHERE id=:gameId")
    fun getSlecetedGame(gameId: Int): GameDto

    @Query("SELECT * FROM game_table WHERE title LIKE '%' || :query || '%' OR genre LIKE '%' || :query || '%'")
    fun searchGames(query: String): List<GameDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGames(games: List<GameDto>)

    @Query("DELETE FROM game_table")
    suspend fun deleteAllGames()
}
