package com.app.myapplication.domain.repository

import com.app.myapplication.domain.model.Pokemon

// Recolectamos aqui la información de la API
// NO LE IMPORTA DE DONDE VIENEN LOS DATOS

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>

    suspend fun getPokemonById(id: String): Pokemon
}
