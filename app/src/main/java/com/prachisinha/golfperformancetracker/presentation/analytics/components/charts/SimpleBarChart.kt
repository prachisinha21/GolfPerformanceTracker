package com.prachisinha.golfperformancetracker.presentation.analytics.components.charts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prachisinha.golfperformancetracker.presentation.analytics.model.SimpleData

@Composable
fun SimpleBarChart(
    title: String,
    data: List<SimpleData>
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

            data.forEach { item ->
                Text(text = "${item.label}: ${item.value}")
            }
        }
    }
}