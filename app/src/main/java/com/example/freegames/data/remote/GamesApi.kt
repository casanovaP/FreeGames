package com.example.freegames.data.remote

import android.util.Log
import com.example.freegames.data.model.GameDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesApi {
    @GET("/games")
    suspend fun getAllGames(): Response<List<GameDto>>

    @GET("games/{gameId}")
    suspend fun getSelectedGame(
        @Path("gameId") gameId: Int
    ): GameDto

    @GET("/games/{title}")
    suspend fun searchGames(
        @Path("title") title: String
    ): List<GameDto>
}