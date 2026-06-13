package com.prachisinha.golfperformancetracker.presentation.players

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.prachisinha.golfperformancetracker.domain.model.Player

@Composable
fun PlayersScreen(
    onPlayerClick: (String) -> Unit = {},
    viewModel: PlayersViewModel = hiltViewModel()
) {
    val players by viewModel.filteredPlayers.collectAsState()

    var searchText by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xff29b3b3))
                    .statusBarsPadding()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {

                Text(
                    text = "Golf Performance Tracker",
                    fontSize = 24.sp,
                    color = Color.White
                )

                Text(
                    text = "Track players and performance metrics",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier.padding(top = 4.dp)
                )

                OutlinedTextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                        viewModel.onSearchQueryChanged(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    placeholder = {
                        Text(
                            text = "Search by player name or club",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surface,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                        focusedTextColor = MaterialTheme.colorScheme.onSurface,
                        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline
                    )
                )
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(12.dp),
        ) {

            items(players) { player ->
                PlayerItemCard(
                    player = player,
                    onClick = {
                        onPlayerClick(player.id)
                    }
                )
            }
        }
    }
}

@Composable
private fun PlayerItemCard(
    player: Player,
    onClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()

    val cardColor = if (isDarkTheme) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        Color(0xfff0fcfc)
    }

    val primaryTextColor = MaterialTheme.colorScheme.onSurface
    val secondaryTextColor = MaterialTheme.colorScheme.onSurfaceVariant

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
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
                    fontSize = 22.sp,
                    color = primaryTextColor
                )

                Text(
                    text = player.club,
                    color = secondaryTextColor
                )
            }

            Text(
                text = "${player.country} • Handicap ${player.handicap}",
                modifier = Modifier.padding(top = 8.dp),
                color = secondaryTextColor
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Column {
                    Text(
                        text = "${player.avgBallSpeed} mph",
                        fontSize = 24.sp,
                        color = primaryTextColor
                    )

                    Text(
                        text = "Ball Speed",
                        color = secondaryTextColor
                    )
                }

                Column {
                    Text(
                        text = "${player.avgCarryDistance} yd",
                        fontSize = 24.sp,
                        color = primaryTextColor
                    )

                    Text(
                        text = "Distance",
                        color = secondaryTextColor
                    )
                }
            }
        }
    }
}