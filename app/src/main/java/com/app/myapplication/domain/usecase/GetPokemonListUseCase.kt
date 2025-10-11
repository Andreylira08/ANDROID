package com.app.myapplication.domain.usecase

import com.app.myapplication.domain.common.Result
import com.app.myapplication.domain.model.Pokemon
import com.app.myapplication.domain.repository.PokemonRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

// El UseCase no crea el repository, lo recibe ya creado.
// Es como un restaurante que no fabrica sus ingredientes, sino que los recibe.
class GetPokemonListUseCase
    @Inject
    constructor(
        private val repository: PokemonRepository,
    ) {
        operator fun invoke(): Flow<Result<List<Pokemon>>> =
            flow {
                try {
                    emit(Result.Loading) // Indicamos que estamos cargando los datos
                    val pokemonList = repository.getPokemonList() // Obtenemos los datos de la API
                    emit(Result.Success(pokemonList)) // Indicamos que los datos se han obtenido correctamente
                } catch (e: Exception) {
                    emit(Result.Error(e))
                }
            }
    }
