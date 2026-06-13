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
    val ballSpeed: Double?,

    @SerializedName("launchAngle")
    val launchAngle: Double?,

    @SerializedName("carryDistance")
    val carryDistance: Double?,

    @SerializedName("spinRate")
    val spinRate: Int?,

    @SerializedName("recordedAt")
    val recordedAt: String?
)