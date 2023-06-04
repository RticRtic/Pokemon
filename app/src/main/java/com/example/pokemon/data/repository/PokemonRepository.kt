package com.example.pokemon.data.repository

import com.example.pokemon.api_service.PokemonApi
import com.example.pokemon.api_service.model.Pokemon


class PokemonRepository(private val pokemonApi: PokemonApi) {

//    private var offset = 0
//    private val limit = 20

    suspend fun getPokemons(): List<Pokemon> {
        val response = pokemonApi.getPokemons()
//        offset += limit


        val pokemonList = response.results.mapIndexedNotNull { index, pokemonResult ->
            if (index % 3 == 0) {
                val pokemonId = pokemonResult.url
                    .removeSuffix("/")
                    .substringAfterLast("/")
                    .toInt()
                pokemonApi.getPokemon(pokemonId)
            } else {
                null
            }
        }
        return pokemonList
    }

    suspend fun getSinglePokemon(id: Int): Pokemon {
        return pokemonApi.getPokemon(id)
    }

}