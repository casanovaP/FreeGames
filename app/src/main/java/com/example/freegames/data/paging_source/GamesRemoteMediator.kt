package com.example.freegames.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.freegames.data.local.GamesDatabase
import com.example.freegames.data.model.GameDto
import com.example.freegames.data.remote.GamesApi

/**
 * will be implemented with paging at a later stage

@OptIn(ExperimentalPagingApi::class)
class GamesRemoteMediator(
    private val api: GamesApi,
    private val database: GamesDatabase
) : RemoteMediator<Int, GameDto>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GameDto>
    ): MediatorResult {
        try {
            val page = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> state.lastItemOrNull()?.id ?: return MediatorResult.Success(
                    endOfPaginationReached = true
                )
            }

            val response = api.getAllGames(page)
            if (response.success) {
                val games = response.games
                val prevPage = response.prevPage
                val nextPage = response.nextPage

                database.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        database.gamesDao().deleteAllGames()
                    }

                    database.gamesDao().addGames(games)
                }

                return MediatorResult.Success(endOfPaginationReached = nextPage == null)
            } else {
                return MediatorResult.Error(Exception(response.message))
            }
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}
 */