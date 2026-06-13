package com.prachisinha.golfperformancetracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prachisinha.golfperformancetracker.presentation.playerdetails.PlayerDetailsScreen
import com.prachisinha.golfperformancetracker.presentation.players.PlayersScreen

@Composable
fun GolfNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.PLAYERS
    ) {

        composable(NavRoutes.PLAYERS) {
            PlayersScreen(
                onPlayerClick = { playerId ->
                    navController.navigate(
                        "${NavRoutes.PLAYER_DETAILS}/$playerId"
                    )
                }
            )
        }

        composable(
            route = "${NavRoutes.PLAYER_DETAILS}/{playerId}"
        ) {
            PlayerDetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}