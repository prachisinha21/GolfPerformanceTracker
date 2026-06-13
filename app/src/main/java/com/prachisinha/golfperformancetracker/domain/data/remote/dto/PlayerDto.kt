package com.prachisinha.golfperformancetracker.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlayerDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("club") val club: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("handicap") val handicap: Int?,
    @SerializedName("avgBallSpeed") val avgBallSpeed: Double?,
    @SerializedName("avgCarryDistance") val avgCarryDistance: Double?,
    @SerializedName("avatarUrl") val avatarUrl: String?
)