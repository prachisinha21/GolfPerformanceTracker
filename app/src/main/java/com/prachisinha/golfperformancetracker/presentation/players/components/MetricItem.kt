package com.prachisinha.golfperformancetracker.presentation.players.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun MetricItem(
    value: String,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}