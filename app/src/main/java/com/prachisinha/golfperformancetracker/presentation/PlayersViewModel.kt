package com.prachisinha.golfperformancetracker.presentation.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prachisinha.golfperformancetracker.domain.model.Player
import com.prachisinha.golfperformancetracker.domain.repository.GolfRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val repository: GolfRepository
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    private val players: StateFlow<List<Player>> =
        repository.getPlayers()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    val filteredPlayers: StateFlow<List<Player>> =
        combine(players, searchQuery) { players, query ->
            if (query.isBlank()) {
                players
            } else {
                players.filter {
                    it.name.contains(query, ignoreCase = true) ||
                            it.club.contains(query, ignoreCase = true)
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
    }

    init {
        refreshPlayers()
    }

    private fun refreshPlayers() {
        viewModelScope.launch {
            repository.refreshPlayers()
            repository.refreshShots()
        }
    }
}