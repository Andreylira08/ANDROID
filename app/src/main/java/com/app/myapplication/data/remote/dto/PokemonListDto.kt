package com.app.myapplication.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonListDto(
    // @SerializedName le dice a Gson como mapear los datos de la API a nuestra clase de datos
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<PokemonResultDto>,
)
