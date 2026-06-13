package com.prachisinha.golfperformancetracker.presentation.analytics

import com.prachisinha.golfperformancetracker.domain.model.Shot
import org.junit.Assert.assertEquals
import org.junit.Test

class AnalyticsMapperTest {

    private val shots = listOf(
        Shot("1", "1", "Driver", 168.0, 12.5, 268.0, 2400, "2026-06-13"),
        Shot("2", "1", "Driver", 160.0, 11.0, 250.0, 2300, "2026-06-13"),
        Shot("3", "1", "Iron", 130.0, 15.0, 150.0, 3000, "2026-06-13"),
        Shot("4", "1", "Wedge", 90.0, 22.0, 80.0, 4500, "2026-06-13")
    )

    @Test
    fun `buildClubUsage returns correct count per club`() {
        val result = AnalyticsMapper.buildClubUsage(shots)

        assertEquals(3, result.size)
        assertEquals(2, result.first { it.label == "Driver" }.value)
        assertEquals(1, result.first { it.label == "Iron" }.value)
        assertEquals(1, result.first { it.label == "Wedge" }.value)
    }

    @Test
    fun `buildSpeedDistance returns speed distance pairs`() {
        val result = AnalyticsMapper.buildSpeedDistance(shots)

        assertEquals(4, result.size)
        assertEquals(168.0, result[0].speed, 0.001)
        assertEquals(268.0, result[0].distance, 0.001)
    }

    @Test
    fun `buildDistanceBuckets returns correct bucket counts`() {
        val result = AnalyticsMapper.buildDistanceBuckets(shots)

        assertEquals(4, result.size)
        assertEquals(0, result.first { it.label == "0–50m" }.value)
        assertEquals(1, result.first { it.label == "50–100m" }.value)
        assertEquals(1, result.first { it.label == "100–150m" }.value)
        assertEquals(2, result.first { it.label == "150m+" }.value)
    }
}