package com.prachisinha.golfperformancetracker.data.repository

import com.prachisinha.golfperformancetracker.data.local.dao.PlayerDao
import com.prachisinha.golfperformancetracker.data.local.dao.ShotDao
import com.prachisinha.golfperformancetracker.data.mapper.toDomain
import com.prachisinha.golfperformancetracker.data.mapper.toEntity
import com.prachisinha.golfperformancetracker.data.remote.GolfApi
import com.prachisinha.golfperformancetracker.domain.model.Player
import com.prachisinha.golfperformancetracker.domain.model.Shot
import com.prachisinha.golfperformancetracker.domain.repository.GolfRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GolfRepositoryImpl @Inject constructor(
    private val golfApi: GolfApi,
    private val playerDao: PlayerDao,
    private val shotDao: ShotDao
) : GolfRepository {

    override fun getPlayers(): Flow<List<Player>> {
        return playerDao.getPlayers()
            .map { entities ->
                entities.map { it.toDomain() }
            }
    }

    override fun getPlayerById(playerId: String): Flow<Player?> {
        return playerDao.getPlayerById(playerId)
            .map { entity ->
                entity?.toDomain()
            }
    }

    override fun getShotsByPlayerId(playerId: String): Flow<List<Shot>> {
        return shotDao.getShotsByPlayerId(playerId)
            .map { entities ->
                entities.map { it.toDomain() }
            }
    }

    override suspend fun refreshPlayers() {
        val players = golfApi.getPlayers()

        playerDao.clearPlayers()

        playerDao.insertPlayers(
            players.map { it.toEntity() }
        )
    }

    override suspend fun refreshShots() {
        val shots = golfApi.getShots()

        shotDao.clearShots()

        shotDao.insertShots(
            shots.map { it.toEntity() }
        )
    }
}