package com.example.pokemon.data.repository

import com.example.pokemon.api_service.ApiConstants
import com.example.pokemon.api_service.PokemonApi
import com.example.pokemon.api_service.model.pokemon.Pokemon


class PokemonRepository(private val pokemonApi: PokemonApi) {
    private var nextUrl: String? = "${ApiConstants.BASE_URL}pokemon?limit=20}"
    suspend fun pokemons(): List<Pokemon> {
        return nextUrl?.let { url ->
            val response = pokemonApi.getPokemons(url)
            val pokemonList = response.results.map { pokemonResult ->
                    val pokemonId = pokemonResult.url
                        .removeSuffix("/")
                        .substringAfterLast("/")
                        .toInt()
                    pokemonApi.getPokemon(pokemonId)
                    getColor(pokemonApi.getPokemon(pokemonId))
                    getPokemonHabitat(pokemonApi.getPokemon(pokemonId))
            }
            nextUrl = response.next
            pokemonList
        } ?: emptyList()

    }

    suspend fun getSinglePokemon(id: Int): Pokemon {
        val pokemon = pokemonApi.getPokemon(id)
        val speciesUrl = pokemon.species?.url
        val species = pokemonApi.getSpecies(speciesUrl ?: "")

        val flavorTextEntry = species.flavor_text_entries
        val flavorText = flavorTextEntry.firstOrNull() { it.language.name == "en" }?.flavor_text
        val updatedPokemon = getPokemonHabitat(pokemon)

        return updatedPokemon.copy(flavorText = flavorText.orEmpty())
    }

    private suspend fun getPokemonHabitat(pokemon: Pokemon): Pokemon {
        val speciesUrl = pokemon.species?.url
        val species = pokemonApi.getSpecies(speciesUrl ?: "")

        val habitatUrl = species.habitat?.url
        val habitat = pokemonApi.getHabitat(habitatUrl ?: "")
        val updatedPokemon = getColor(pokemon)

        return updatedPokemon.copy(habitat = habitat.name)
    }

    private suspend fun getColor(pokemon: Pokemon): Pokemon {
        val speciesUrl = pokemon.species?.url ?: ""
        val species = pokemonApi.getSpecies(speciesUrl)

        val colorUrl = species.color?.url
        val color = pokemonApi.getColor(colorUrl ?: "")

        return pokemon.copy(color = color.name)
    }
}