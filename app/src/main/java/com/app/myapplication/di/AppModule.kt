package com.app.myapplication.di

import com.app.myapplication.data.remote.api.PokemonApi
import com.app.myapplication.data.repository.PokemonRepositoryImpl
import com.app.myapplication.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// di/AppModule.kt

// Utilizamos module para poder realizar la configuración necesaria con la API
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonApi): PokemonRepository = PokemonRepositoryImpl(api)
}

// Si alguien necesita un PokemonRepository:

// Hilt ve que hay un @Provides para PokemonRepository
// Pero necesita un PokemonApi para crearlo
//
// Entonces busca cómo crear PokemonApi
// Encuentra providePokemonApi
// Pero necesita un Retrofit
//
// Busca cómo crear Retrofit
// Encuentra provideRetrofit
// Este no necesita nada más
//
// Ahora puede:
// Crear Retrofit
// Usar ese Retrofit para crear PokemonApi
// Usar ese PokemonApi para crear PokemonRepository
// Inyectar ese PokemonRepository en MyViewModel
//
// Es como una receta:
//
// Para hacer un pastel (PokemonRepository)
// Necesito masa (PokemonApi)
// Para hacer masa necesito harina (Retrofit)
// Hilt sigue la receta al revés hasta tener todos los ingredientes
