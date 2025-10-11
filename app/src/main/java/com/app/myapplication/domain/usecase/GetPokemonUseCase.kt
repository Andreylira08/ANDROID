package com.app.myapplication.domain.usecase

import com.app.myapplication.domain.common.Result
import com.app.myapplication.domain.model.Pokemon
import com.app.myapplication.domain.repository.PokemonRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPokemonUseCase
    @Inject
    constructor(
        private val repository: PokemonRepository,
    ) {
        operator fun invoke(id: String): Flow<Result<Pokemon>> =
            flow {
                try {
                    emit(Result.Loading)
                    val pokemon = repository.getPokemonById(id)
                    emit(Result.Success(pokemon))
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
    }
