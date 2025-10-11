package com.app.myapplication.data.remote.api

import com.app.myapplication.data.remote.dto.PokemonDto
import com.app.myapplication.data.remote.dto.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Libreria que realiza las llamadas a la API(Retrofit). Esta pide que utilizemos interface de tipo de archivo
interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        // Hacemos la llamada GET mediante un QUERY para pasar la información que necesita la API
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonListDto

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        // Hacemos la llamada GET mediante un PATH para pasar la información que necesita la API
        @Path("id") id: String,
    ): PokemonDto
}
