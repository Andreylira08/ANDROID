package com.app.myapplication.data.mapper

import com.app.myapplication.data.remote.dto.PokemonDto
import com.app.myapplication.domain.model.Pokemon

// Creamos un objeto para mapear los datos de la API a nuestra clase de datos

fun PokemonDto.toDomain(): Pokemon =
    Pokemon(
        id = id.toString(),
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = sprites.frontDefault,
        weight = weight,
        height = height,
        types = types.map { it.type.name },
    )
