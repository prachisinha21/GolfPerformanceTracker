package com.prachisinha.golfperformancetracker.data.mapper

import com.prachisinha.golfperformancetracker.data.local.entity.PlayerEntity
import com.prachisinha.golfperformancetracker.data.remote.dto.PlayerDto
import com.prachisinha.golfperformancetracker.domain.model.Player

fun PlayerDto.toEntity(): PlayerEntity {
    return PlayerEntity(
        id = id,
        name = name.orEmpty(),
        club = club.orEmpty(),
        country = country.orEmpty(),
        handicap = handicap?.toIntOrNull() ?: 0,
        avgBallSpeed = avgBallSpeed?.toDoubleOrNull() ?: 0.0,
        avgCarryDistance = avgCarryDistance?.toDoubleOrNull() ?: 0.0,
        avatarUrl = avatarUrl.orEmpty()
    )
}
fun PlayerEntity.toDomain(): Player {
    return Player(
        id = id,
        name = name,
        club = club,
        country = country,
        handicap = handicap,
        avgBallSpeed = avgBallSpeed,
        avgCarryDistance = avgCarryDistance,
        avatarUrl = avatarUrl
    )
}