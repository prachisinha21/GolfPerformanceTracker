package com.prachisinha.golfperformancetracker.presentation.analytics

import com.prachisinha.golfperformancetracker.domain.model.Shot
import com.prachisinha.golfperformancetracker.presentation.analytics.model.SimpleData
import com.prachisinha.golfperformancetracker.presentation.analytics.model.SpeedDistanceData

/**
 * Maps raw Shot data into analytics-ready structures
 */
object AnalyticsMapper {

    /**
     * 📏 Distance distribution in buckets
     */
    fun buildDistanceBuckets(shots: List<Shot>): List<SimpleData> {

        val buckets = mapOf(
            "0–50m" to shots.count { it.carryDistance in 0.0..50.0 },
            "50–100m" to shots.count { it.carryDistance in 50.0..100.0 },
            "100–150m" to shots.count { it.carryDistance in 100.0..150.0 },
            "150m+" to shots.count { it.carryDistance > 150.0 }
        )

        return buckets.map {
            SimpleData(
                label = it.key,
                value = it.value
            )
        }
    }

    /**
     * 🏌️ Club usage distribution
     */
    fun buildClubUsage(shots: List<Shot>): List<SimpleData> {

        return shots.groupingBy { it.clubType }
            .eachCount()
            .map {
                SimpleData(
                    label = it.key,
                    value = it.value
                )
            }
    }

    /**
     * ⚡ Speed vs Distance scatter data
     */
    fun buildSpeedDistance(shots: List<Shot>): List<SpeedDistanceData> {

        return shots.map {
            SpeedDistanceData(
                speed = it.ballSpeed,
                distance = it.carryDistance
            )
        }
    }
}