package com.prachisinha.golfperformancetracker.presentation.players.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prachisinha.golfperformancetracker.domain.model.Player

@Composable
fun PlayerCard(
    player: Player,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = player.name,
                    style = MaterialTheme.typography.headlineSmall
                )

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {

                    Text(
                        text = player.club,
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        ),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Text(
                text = "${player.country} • Handicap ${player.handicap}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                MetricItem(
                    value = "${(player.avgBallSpeed ?: 0.0).toInt()} mph",
                    label = "Ball Speed"
                )

                MetricItem(
                    value = "${player.avgCarryDistance?: 0.0.toInt()} yd",
                    label = "Distance"
                )
            }
        }
    }
}