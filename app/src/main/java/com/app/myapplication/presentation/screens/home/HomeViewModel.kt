package com.app.myapplication.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.myapplication.domain.common.Result
import com.app.myapplication.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// ES NECESARIO INDICAR QUIEN ES EL VIEWMODEL
@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getPokemonListUseCase: GetPokemonListUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(HomeUiState())
        val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

        init {
            loadPokemonList()
        }

        private fun loadPokemonList() {
            viewModelScope.launch {
                getPokemonListUseCase().collect { result ->
                    _uiState.update { state ->
                        when (result) {
                            is Result.Loading ->
                                state.copy(
                                    isLoading = true,
                                )
                            is Result.Success ->
                                state.copy(
                                    pokemonList = result.data,
                                    isLoading = false,
                                    error = null,
                                )
                            is Result.Error ->
                                state.copy(
                                    error = result.exception.message,
                                    isLoading = false,
                                )

                            is com.app.myapplication.domain.common.Result.Error -> TODO()
                            com.app.myapplication.domain.common.Result.Loading -> TODO()
                            is com.app.myapplication.domain.common.Result.Success<*> -> TODO()
                        }
                    }
                }
            }
        }
    }
