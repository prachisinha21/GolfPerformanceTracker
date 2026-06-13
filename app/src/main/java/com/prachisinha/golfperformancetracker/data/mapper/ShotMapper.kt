package com.prachisinha.golfperformancetracker.data.mapper

import com.prachisinha.golfperformancetracker.data.local.entity.ShotEntity
import com.prachisinha.golfperformancetracker.domain.data.remote.dto.ShotDto
import com.prachisinha.golfperformancetracker.domain.model.Shot

fun ShotDto.toEntity(): ShotEntity {
    return ShotEntity(
        id = id.orEmpty(),
        playerId = playerId.orEmpty(),
        clubType = clubType.orEmpty(),
        ballSpeed = ballSpeed?.toDoubleOrNull() ?: 0.0,
        launchAngle = launchAngle?.toDoubleOrNull() ?: 0.0,
        carryDistance = carryDistance?.toDoubleOrNull() ?: 0.0,
        spinRate = spinRate?.toIntOrNull() ?: 0,
        recordedAt = recordedAt.orEmpty()
    )
}

fun ShotEntity.toDomain(): Shot {
    return Shot(
        id = id,
        playerId = playerId,
        clubType = clubType,
        ballSpeed = ballSpeed,
        launchAngle = launchAngle,
        carryDistance = carryDistance,
        spinRate = spinRate,
        recordedAt = recordedAt
    )
}