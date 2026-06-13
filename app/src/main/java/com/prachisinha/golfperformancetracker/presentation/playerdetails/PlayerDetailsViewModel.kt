package com.prachisinha.golfperformancetracker.presentation.playerdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.prachisinha.golfperformancetracker.domain.model.Player
import com.prachisinha.golfperformancetracker.domain.model.Shot
import com.prachisinha.golfperformancetracker.domain.repository.GolfRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PlayerDetailsViewModel @Inject constructor(
    repository: GolfRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val playerId: String =
        savedStateHandle.get<String>("playerId") ?: ""

    val player: Flow<Player?> =
        repository.getPlayerById(playerId)

    val shots: Flow<List<Shot>> =
        repository.getShotsByPlayerId(playerId)
}