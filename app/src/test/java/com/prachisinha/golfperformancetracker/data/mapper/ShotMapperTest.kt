package com.prachisinha.golfperformancetracker.data.mapper

import com.prachisinha.golfperformancetracker.domain.data.remote.dto.ShotDto
import org.junit.Assert.assertEquals
import org.junit.Test

class ShotMapperTest {

    @Test
    fun `toEntity maps valid shot dto correctly`() {
        val dto = ShotDto(
            id = "1",
            playerId = "1",
            clubType = "Driver",
            ballSpeed = "168",
            launchAngle = "12.5",
            carryDistance = "268",
            spinRate = "2400",
            recordedAt = "2026-06-13"
        )

        val entity = dto.toEntity()

        assertEquals("1", entity.id)
        assertEquals("1", entity.playerId)
        assertEquals("Driver", entity.clubType)
        assertEquals(168.0, entity.ballSpeed, 0.001)
        assertEquals(12.5, entity.launchAngle, 0.001)
        assertEquals(268.0, entity.carryDistance, 0.001)
        assertEquals(2400, entity.spinRate)
        assertEquals("2026-06-13", entity.recordedAt)
    }

    @Test
    fun `toEntity handles malformed numeric shot fields safely`() {
        val dto = ShotDto(
            id = "2",
            playerId = "1",
            clubType = "Iron",
            ballSpeed = "Invalid faker method - random.word",
            launchAngle = "Invalid faker method - random.word",
            carryDistance = "Invalid faker method - random.word",
            spinRate = "Invalid faker method - random.word",
            recordedAt = "2026-06-13"
        )

        val entity = dto.toEntity()

        assertEquals("2", entity.id)
        assertEquals("1", entity.playerId)
        assertEquals("Iron", entity.clubType)
        assertEquals(0.0, entity.ballSpeed, 0.001)
        assertEquals(0.0, entity.launchAngle, 0.001)
        assertEquals(0.0, entity.carryDistance, 0.001)
        assertEquals(0, entity.spinRate)
    }
}