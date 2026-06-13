package com.prachisinha.golfperformancetracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prachisinha.golfperformancetracker.data.local.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * from players")
    fun getPlayers(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM players WHERE id = :playerId")
    fun getPlayerById(playerId: String): Flow<PlayerEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: List<PlayerEntity>)

    @Query("DELETE FROM players")
    suspend fun clearPlayers()
}