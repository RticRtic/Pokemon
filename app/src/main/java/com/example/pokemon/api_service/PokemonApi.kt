package com.example.pokemon.api_service

import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionChainResponse
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionSpecies
import com.example.pokemon.api_service.model.pokemon.Ability
import com.example.pokemon.api_service.model.pokemon.PokemonColor
import com.example.pokemon.api_service.model.pokemon.Habitat
import com.example.pokemon.api_service.model.pokemon.Pokemon
import com.example.pokemon.api_service.model.pokemon.PokemonResponse
import com.example.pokemon.api_service.model.pokemon.Species
import com.example.pokemon.api_service.model.pokemon.Stat
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApi {

    @GET
    suspend fun getPokemons(@Url url: String): PokemonResponse

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon
    @GET
    suspend fun getSpecies(@Url url: String): Species
    @GET
    suspend fun getHabitat(@Url url: String): Habitat
    @GET
    suspend fun getColor(@Url url: String): PokemonColor

}