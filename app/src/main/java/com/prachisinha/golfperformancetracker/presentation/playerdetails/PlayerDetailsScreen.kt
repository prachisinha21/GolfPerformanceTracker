package com.prachisinha.golfperformancetracker.presentation.playerdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prachisinha.golfperformancetracker.presentation.analytics.PlayerAnalyticsSection

@Composable
fun PlayerDetailsScreen(
    onBackClick: () -> Unit,
    viewModel: PlayerDetailsViewModel = hiltViewModel()
) {
    val player by viewModel.player.collectAsState(initial = null)
    val shots by viewModel.shots.collectAsState(initial = emptyList())

    val isDarkTheme = isSystemInDarkTheme()

    val infoCardColor = if (isDarkTheme) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        Color(0xFFE3F2FD)
    }

    val shotCardColor = if (isDarkTheme) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        Color(0xfff0fcfc)
    }

    val primaryTextColor = MaterialTheme.colorScheme.onSurface
    val secondaryTextColor = MaterialTheme.colorScheme.onSurfaceVariant
    val headingTextColor = MaterialTheme.colorScheme.onBackground

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xff29b3b3)
                ),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.clickable { onBackClick() }
                    )

                    Text(
                        text = "Player Details",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            player?.let {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = infoCardColor
                    ),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.headlineSmall,
                            color = primaryTextColor
                        )

                        Text(
                            text = "Country: ${it.country}",
                            color = secondaryTextColor
                        )

                        Text(
                            text = "Club: ${it.club}",
                            color = secondaryTextColor
                        )

                        Text(
                            text = "Handicap: ${it.handicap}",
                            color = secondaryTextColor
                        )

                        Text(
                            text = "Average Ball Speed: ${it.avgBallSpeed} mph",
                            color = secondaryTextColor
                        )

                        Text(
                            text = "Average Distance: ${it.avgCarryDistance} yd",
                            color = secondaryTextColor
                        )
                    }
                }
            }
        }

        item {
            Text(
                text = "Recent Shots",
                style = MaterialTheme.typography.headlineSmall,
                color = headingTextColor,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
        }

        items(shots) { shot ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = shotCardColor
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = shot.clubType,
                        style = MaterialTheme.typography.titleMedium,
                        color = primaryTextColor
                    )

                    Text(
                        text = "Ball Speed: ${shot.ballSpeed} mph",
                        color = secondaryTextColor
                    )

                    Text(
                        text = "Carry Distance: ${shot.carryDistance} yd",
                        color = secondaryTextColor
                    )

                    Text(
                        text = "Launch Angle: ${shot.launchAngle}°",
                        color = secondaryTextColor
                    )

                    Text(
                        text = "Spin Rate: ${shot.spinRate} rpm",
                        color = secondaryTextColor
                    )
                }
            }
        }

        item {
            PlayerAnalyticsSection(
                shots = shots
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}