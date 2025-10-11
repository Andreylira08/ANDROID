package com.app.myapplication.presentation.screens.home

import com.app.myapplication.domain.model.Pokemon

data class HomeUiState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
