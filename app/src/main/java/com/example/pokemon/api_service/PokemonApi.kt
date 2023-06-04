package com.example.pokemon.api_service

import com.example.pokemon.api_service.model.Pokemon
import com.example.pokemon.api_service.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon/")
    suspend fun getPokemons(
       @Query("limit") limit: Int,
       @Query("offset") offset: Int
    ): PokemonResponse

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon
}