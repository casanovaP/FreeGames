package com.example.freegames.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.freegames.utils.Constants.GAME_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = GAME_TABLE)
data class GameDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freeToGameProfileUrl: String,
    @SerializedName("game_url")
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("short_description")
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)