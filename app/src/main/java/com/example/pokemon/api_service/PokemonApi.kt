package com.example.pokemon.api_service

import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionChain
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionChainResponse
import com.example.pokemon.api_service.model.pokemon.Pokemon
import com.example.pokemon.api_service.model.pokemon.PokemonResponse
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

    @GET("evolution-chain/{id}/")
    suspend fun getEvolutionChain(@Path("id") id: Int): EvolutionChainResponse


}