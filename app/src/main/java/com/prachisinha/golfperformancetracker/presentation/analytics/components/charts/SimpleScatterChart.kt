package com.prachisinha.golfperformancetracker.presentation.analytics.components.charts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prachisinha.golfperformancetracker.presentation.analytics.model.SpeedDistanceData

@Composable
fun SimpleScatterChart(
    title: String,
    data: List<SpeedDistanceData>
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Simple fallback UI (no chart library yet)
            // We just list points clearly for now

            data.forEach { point ->
                Text(
                    text = "Speed: ${point.speed} km/h  →  Distance: ${point.distance} m"
                )
            }
        }
    }
}