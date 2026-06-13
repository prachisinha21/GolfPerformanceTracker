package com.prachisinha.golfperformancetracker.presentation.analytics.components

import androidx.compose.runtime.*
import com.prachisinha.golfperformancetracker.domain.model.Shot
import com.prachisinha.golfperformancetracker.presentation.analytics.components.charts.SimpleBarChart
import com.prachisinha.golfperformancetracker.presentation.analytics.model.SimpleData

@Composable
fun DistanceDistributionChart(shots: List<Shot>) {

    val data = remember(shots) {
        buildDistanceBuckets(shots)
    }

    SimpleBarChart(
        title = "Distance Distribution",
        data = data
    )
}

private fun buildDistanceBuckets(shots: List<Shot>): List<SimpleData> {

    val buckets = mapOf(
        "0-50m" to shots.count { it.carryDistance in 0.0..50.0 },
        "50-100m" to shots.count { it.carryDistance in 50.0..100.0 },
        "100-150m" to shots.count { it.carryDistance in 100.0..150.0 },
        "150m+" to shots.count { it.carryDistance > 150.0 }
    )

    return buckets.map {
        SimpleData(it.key, it.value)
    }
}