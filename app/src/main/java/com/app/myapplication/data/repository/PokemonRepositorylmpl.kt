package com.app.myapplication.data.repository

import com.app.myapplication.data.mapper.toDomain
import com.app.myapplication.data.remote.api.PokemonApi
import com.app.myapplication.domain.model.Pokemon
import com.app.myapplication.domain.repository.PokemonRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

// Singleton: solo habrá una instancia
@Singleton
class PokemonRepositoryImpl
    @Inject
    constructor(
        private val api: PokemonApi,
    ) : PokemonRepository {
        override suspend fun getPokemonList(): List<Pokemon> {
            val response = api.getPokemonList()
            return response.results.map { result ->
                // Obtenemos el id de la URL
                val id =
                    result.url
                        .split("/")
                        .dropLast(1)
                        .last()
                // Hacemos la llamada para obtener detalles
                api.getPokemon(id).toDomain()
            }
        }

        override suspend fun getPokemonById(id: String): Pokemon = api.getPokemon(id).toDomain()
    }
