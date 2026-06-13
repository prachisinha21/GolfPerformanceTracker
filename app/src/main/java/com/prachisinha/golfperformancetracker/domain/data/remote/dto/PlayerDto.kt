package com.prachisinha.golfperformancetracker.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlayerDto(
    val id: String,
    val name: String?,
    val club: String?,
    val country: String?,
    val handicap: String?,
    val avgBallSpeed: String?,
    val avgCarryDistance: String?,
    val avatarUrl: String?
)