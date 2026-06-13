package com.prachisinha.golfperformancetracker.data.remote

import com.prachisinha.golfperformancetracker.data.remote.dto.PlayerDto
import com.prachisinha.golfperformancetracker.domain.data.remote.dto.ShotDto
import retrofit2.http.GET

interface GolfApi {

    @GET("players")
    suspend fun getPlayers(): List<PlayerDto>

    @GET("shots")
    suspend fun getShots(): List<ShotDto>
}