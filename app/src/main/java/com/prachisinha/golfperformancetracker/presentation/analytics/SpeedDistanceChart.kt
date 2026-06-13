package com.prachisinha.golfperformancetracker.presentation.analytics.components

import androidx.compose.runtime.*
import com.prachisinha.golfperformancetracker.domain.model.Shot
import com.prachisinha.golfperformancetracker.presentation.analytics.components.charts.SimpleScatterChart
import com.prachisinha.golfperformancetracker.presentation.analytics.model.SpeedDistanceData

@Composable
fun SpeedDistanceChart(shots: List<Shot>) {

    val data = remember(shots) {
        shots.map {
            SpeedDistanceData(
                speed = it.ballSpeed,
                distance = it.carryDistance
            )
        }
    }

    SimpleScatterChart(
        title = "Speed vs Distance",
        data = data
    )
}