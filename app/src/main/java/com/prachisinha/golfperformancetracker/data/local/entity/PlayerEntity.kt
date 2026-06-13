package com.prachisinha.golfperformancetracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class PlayerEntity(

    @PrimaryKey
    val id: String,
    val name: String,
    val club: String,
    val country: String,
    val handicap:Int,
    val avgBallSpeed: Double,
    val avgCarryDistance: Double,
    val avatarUrl: String
)