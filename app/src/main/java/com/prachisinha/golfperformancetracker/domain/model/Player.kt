package com.prachisinha.golfperformancetracker.domain.model

data class Player(
    val id: String,
    val name: String,
    val club: String,
    val country: String,
    val handicap: Int,            // safer than Int
    val avgBallSpeed: Double?,
    val avgCarryDistance: Double?,
    val avatarUrl: String?
)