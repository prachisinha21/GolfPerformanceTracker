package com.prachisinha.golfperformancetracker.presentation.analytics

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prachisinha.golfperformancetracker.domain.model.Shot
import com.prachisinha.golfperformancetracker.presentation.analytics.components.ClubUsageChart
import com.prachisinha.golfperformancetracker.presentation.analytics.components.DistanceDistributionChart
import com.prachisinha.golfperformancetracker.presentation.analytics.components.SpeedDistanceChart

@Composable
fun PlayerAnalyticsSection(
    shots: List<Shot>
) {
    var showAnalytics by remember { mutableStateOf(false) }

    LaunchedEffect(shots) {
        if (shots.isNotEmpty()) {
            showAnalytics = false
            kotlinx.coroutines.delay(200)
            showAnalytics = true
        }
    }

    AnimatedVisibility(
        visible = showAnalytics,
        enter = fadeIn(
            animationSpec = tween(durationMillis = 800)
        ) + slideInVertically(
            animationSpec = tween(durationMillis = 800),
            initialOffsetY = { it / 2 }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Analytics",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))
            DistanceDistributionChart(shots)
            Spacer(modifier = Modifier.height(16.dp))
            SpeedDistanceChart(shots)
            Spacer(modifier = Modifier.height(16.dp))
            ClubUsageChart(shots)
        }
    }
}