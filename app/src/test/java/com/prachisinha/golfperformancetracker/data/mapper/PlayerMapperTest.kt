package com.prachisinha.golfperformancetracker.data.mapper

import com.prachisinha.golfperformancetracker.data.remote.dto.PlayerDto
import org.junit.Assert.assertEquals
import org.junit.Test

class PlayerMapperTest {

    @Test
    fun `toEntity maps valid player dto correctly`() {
        val dto = PlayerDto(
            id = "1",
            name = "Alex Carter",
            club = "Driver",
            country = "USA",
            handicap = "2",
            avgBallSpeed = "168",
            avgCarryDistance = "268",
            avatarUrl = "https://i.pravatar.cc/300?img=12"
        )

        val entity = dto.toEntity()

        assertEquals("1", entity.id)
        assertEquals("Alex Carter", entity.name)
        assertEquals("Driver", entity.club)
        assertEquals("USA", entity.country)
        assertEquals(2, entity.handicap)
        assertEquals(168.0, entity.avgBallSpeed, 0.001)
        assertEquals(268.0, entity.avgCarryDistance, 0.001)
        assertEquals("https://i.pravatar.cc/300?img=12", entity.avatarUrl)
    }

    @Test
    fun `toEntity handles malformed numeric player fields safely`() {
        val dto = PlayerDto(
            id = "3",
            name = "Invalid faker method - random.word",
            club = "Invalid faker method - random.word",
            country = "Invalid faker method - random.word",
            handicap = "Invalid faker method - random.word",
            avgBallSpeed = "Invalid faker method - random.word",
            avgCarryDistance = "Invalid faker method - random.word",
            avatarUrl = "Invalid faker method - random.word"
        )

        val entity = dto.toEntity()

        assertEquals("3", entity.id)
        assertEquals(0, entity.handicap)
        assertEquals(0.0, entity.avgBallSpeed, 0.001)
        assertEquals(0.0, entity.avgCarryDistance, 0.001)
    }
}