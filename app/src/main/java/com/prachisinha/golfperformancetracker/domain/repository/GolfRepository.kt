package com.prachisinha.golfperformancetracker.domain.repository

import com.prachisinha.golfperformancetracker.domain.model.Player
import com.prachisinha.golfperformancetracker.domain.model.Shot
import kotlinx.coroutines.flow.Flow

interface GolfRepository {

    fun getPlayers(): Flow<List<Player>>

    fun getPlayerById(playerId: String): Flow<Player?>

    fun getShotsByPlayerId(playerId: String): Flow<List<Shot>>

    suspend fun refreshPlayers()

    suspend fun refreshShots()
}