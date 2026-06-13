package com.prachisinha.golfperformancetracker.domain.model

data class Shot(
    val id: String,
    val playerId: String,
    val clubType: String,
    val ballSpeed: Double,
    val launchAngle: Double,
    val carryDistance: Double,
    val spinRate: Int,
    val recordedAt: String
)