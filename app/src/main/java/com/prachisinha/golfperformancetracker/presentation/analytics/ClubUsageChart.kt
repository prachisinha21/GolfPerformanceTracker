package com.prachisinha.golfperformancetracker.presentation.analytics.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prachisinha.golfperformancetracker.domain.model.Shot
import kotlin.math.roundToInt

@Composable
fun ClubUsageChart(shots: List<Shot>) {

    val grouped = shots.groupingBy { it.clubType }
        .eachCount()
        .toList()
        .sortedByDescending { it.second }

    val maxValue = (grouped.maxOfOrNull { it.second } ?: 1).toFloat()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Club Usage",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ---------------- CHART ----------------
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {

                val chartHeight = size.height
                val chartWidth = size.width

                val barWidth = chartWidth / (grouped.size * 2f)

                // Y grid lines
                val steps = 4
                for (i in 0..steps) {
                    val y = chartHeight - (chartHeight / steps) * i

                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, y),
                        end = Offset(chartWidth, y),
                        strokeWidth = 1f
                    )
                }

                // Bars
                grouped.forEachIndexed { index, (_, count) ->

                    val barHeight = (count / maxValue) * chartHeight

                    val x = index * barWidth * 2f
                    val y = chartHeight - barHeight

                    drawRect(
                        color = Color(0xFF29B3B3),
                        topLeft = Offset(x, y),
                        size = androidx.compose.ui.geometry.Size(
                            width = barWidth,
                            height = barHeight
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ---------------- LABELS (SAFE VERSION) ----------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                grouped.forEach { (club, _) ->
                    Text(
                        text = club,
                        style = MaterialTheme.typography.labelSmall,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Max: ${maxValue.roundToInt()} shots",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}