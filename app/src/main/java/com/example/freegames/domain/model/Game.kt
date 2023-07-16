package com.example.freegames.domain.model

import com.example.freegames.data.model.GameDto

data class Game(
    val id: Int,
    val developer: String,
    val freeToGameProfileUrl: String,
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)

// mapperrrrr! with Kotlin's destructuring declaration, aha, yesh!
fun GameDto.toGame(): Game {
    return Game(
        id,
        developer,
        freeToGameProfileUrl,
        gameUrl,
        genre,
        platform,
        publisher,
        releaseDate,
        shortDescription,
        thumbnail,
        title
    )
}

