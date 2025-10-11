package com.app.myapplication.presentation.screens.detail

import com.app.myapplication.domain.model.Pokemon

data class PokemonDetailUiState(
    val pokemon: Pokemon? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
