package com.prachisinha.golfperformancetracker.domain.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ShotDto(

    @SerializedName("id")
    val id: String?,

    @SerializedName("playerId")
    val playerId: String?,

    @SerializedName("clubType")
    val clubType: String?,

    @SerializedName("ballSpeed")
    val ballSpeed: String?,

    @SerializedName("launchAngle")
    val launchAngle: String?,

    @SerializedName("carryDistance")
    val carryDistance: String?,

    @SerializedName("spinRate")
    val spinRate: String?,

    @SerializedName("recordedAt")
    val recordedAt: String?
)