package com.prachisinha.golfperformancetracker.presentation.players

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
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
            HeaderSection(
                searchText = searchText,
                onSearchChanged = {
                    searchText = it
                    viewModel.onSearchQueryChanged(it)
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                if (isSystemInDarkTheme())
                    Color(0xFF121826)
                else
                    MaterialTheme.colorScheme.background
            )
                .padding(paddingValues),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 18.dp,
                bottom = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(18.dp)
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
private fun HeaderSection(
    searchText: String,
    onSearchChanged: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff20b8b8),
                        Color(0xff29b3b3),
                        Color(0xff44c7c7)
                    )
                )
            )
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Column {

            Text(
                text = "Golf Performance Tracker",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Track players and performance metrics",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.padding(top = 6.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = onSearchChanged,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Search by player name or club",
                        color = Color(0xff7a7f87)
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,

                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,

                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,

                    focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,

                    cursorColor = MaterialTheme.colorScheme.primary
                )
            )
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
        Color(0xFF23363D)
    } else {
        Color.White
    }

    val primaryTextColor = MaterialTheme.colorScheme.onSurface
    val secondaryTextColor = MaterialTheme.colorScheme.onSurfaceVariant
    val accentColor = Color(0xff29b3b3)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isDarkTheme) 3.dp else 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                AsyncImage(
                    model = player.avatarUrl?.takeIf { it.isNotBlank() },
                    contentDescription = player.name,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .border(
                            width = 3.dp,
                            color = accentColor.copy(alpha = 0.45f),
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(18.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = player.name,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryTextColor
                    )

                    Text(
                        text = player.club,
                        fontSize = 15.sp,
                        color = secondaryTextColor,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Surface(
                        modifier = Modifier.padding(top = 10.dp),
                        shape = RoundedCornerShape(50),
                        color = accentColor.copy(alpha = 0.12f)
                    ) {
                        Text(
                            text = "${player.country} • Handicap ${player.handicap}",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            fontSize = 13.sp,
                            color = accentColor,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                StatBox(
                    modifier = Modifier.weight(1f),
                    value = "${player.avgBallSpeed ?: 0.0} mph",
                    label = "Ball Speed"
                )

                StatBox(
                    modifier = Modifier.weight(1f),
                    value = "${player.avgCarryDistance ?: 0.0} yd",
                    label = "Distance"
                )
            }
        }
    }
}

@Composable
private fun StatBox(
    modifier: Modifier = Modifier,
    value: String,
    label: String
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        color = if (isSystemInDarkTheme()) {
            Color(0xFF2A3142)
        } else {
            Color(0xFFF5F7FA)
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = label,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}