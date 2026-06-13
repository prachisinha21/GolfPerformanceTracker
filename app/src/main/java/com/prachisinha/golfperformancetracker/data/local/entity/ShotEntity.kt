package com.prachisinha.golfperformancetracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shots")
data class ShotEntity(

    @PrimaryKey
    val id: String,
    val playerId: String,
    val clubType: String,
    val ballSpeed: Double,
    val launchAngle: Double,
    val carryDistance: Double,
    val spinRate: Int,
    val recordedAt: String
)