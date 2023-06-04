package com.example.pokemon.data.repository

import androidx.compose.runtime.rememberCoroutineScope
import com.example.pokemon.api_service.PokemonApi
import com.example.pokemon.api_service.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepository(private val pokemonApi: PokemonApi) {

    private var offset = 0
    private val limit = 20

    suspend fun getPokemons(): List<Pokemon> {
        val response = pokemonApi.getPokemons()
        offset += limit
        val pokemonList = response.results.map { pokemonResult ->
            val pokemonId = pokemonResult.url
                .removeSuffix("/")
                .substringAfterLast("/")
                .toInt()
            pokemonApi.getPokemon(pokemonId)
        }
        return pokemonList
    }

    suspend fun getSinglePokemon(id: Int): Pokemon {
        return pokemonApi.getPokemon(id)
    }

}