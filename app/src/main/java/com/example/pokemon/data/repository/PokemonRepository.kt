package com.example.pokemon.data.repository

import com.example.pokemon.api_service.ApiConstants
import com.example.pokemon.api_service.PokemonApi
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionChain
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionSpecies
import com.example.pokemon.api_service.model.pokemon.Pokemon


class PokemonRepository(private val pokemonApi: PokemonApi) {
    private var nextUrl: String? = "${ApiConstants.BASE_URL}pokemon?limit=50}"
    suspend fun pokemons(): List<Pokemon> {
        return nextUrl?.let { url ->
            val response = pokemonApi.getPokemons(url)
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

            nextUrl = response.next
            pokemonList
        } ?: emptyList()

    }








    suspend fun getSinglePokemon(id: Int): Pokemon {
        val pokemon = pokemonApi.getPokemon(id)
        val evolvedForms = getEvolvedForms(id)
        return pokemon.copy(evolvedForms = evolvedForms)
    }

    private suspend fun getEvolvedForms(id: Int): List<EvolutionSpecies> {
        val evolutionChainResponse = pokemonApi.getEvolutionChain(id)
        val chain = evolutionChainResponse.chain
        val evolutionSpeciesList = mutableListOf<EvolutionSpecies>()
        parseEvolutionChain(chain, evolutionSpeciesList)
        fetchEvolvedSprites(evolutionSpeciesList)
        return evolutionSpeciesList
    }

    private suspend fun fetchEvolvedSprites(evolutionSpeciesList: MutableList<EvolutionSpecies>) {
        evolutionSpeciesList.forEach { species ->
            val id = species.url
                .removeSuffix("/")
                .substringAfterLast("/")
                .toInt()

            val pokemon = pokemonApi.getPokemon(id)
            species.sprite = pokemon.sprites.front_default

        }
    }

    private fun parseEvolutionChain(
        evolutionChain: EvolutionChain,
        evolutionSpeciesList: MutableList<EvolutionSpecies>
    ) {
        val species = evolutionChain.species
        if (species != null) {
            evolutionSpeciesList.add(species)
        }
        if (evolutionChain.evolves_to.isNotEmpty()) {
            evolutionChain.evolves_to.forEach { childChain ->
                parseEvolutionChain(childChain, evolutionSpeciesList)
            }
        }

    }
}