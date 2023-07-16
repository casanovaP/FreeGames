package com.example.freegames.data.remote

import com.example.freegames.data.model.GameDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesApi {

    @GET("/games")
    suspend fun getAllGames(
        @Query("page") page: Int? = 1
    ): List<GameDto>

    @GET("games/{gameId}")
    suspend fun getSelectedGame(
        @Path("gameId") gameId: Int
    ): GameDto

    @GET("/games/{title}")
    suspend fun searchGames(
        @Query("title") title: String
    ): List<GameDto>

}