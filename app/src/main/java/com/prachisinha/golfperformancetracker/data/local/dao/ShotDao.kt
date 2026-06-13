package com.prachisinha.golfperformancetracker.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prachisinha.golfperformancetracker.data.local.entity.ShotEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShotDao {

    @Query("SELECT * FROM shots WHERE playerId = :playerId")
    fun getShotsByPlayerId(playerId: String): Flow<List<ShotEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShots(shots: List<ShotEntity>)

    @Query("DELETE FROM shots")
    suspend fun clearShots()
}