package com.example.pokemon.api_service

import com.example.pokemon.api_service.model.Pokemon
import com.example.pokemon.api_service.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon-species/")
    suspend fun getPokemonList(): PokemonResponse

    @GET("pokemon-species/{name}/")
    suspend fun getPokemon(@Query("name") pokemonName: String): Pokemon
}