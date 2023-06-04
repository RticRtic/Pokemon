package com.example.pokemon.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pokemon.api_service.model.PokemonResult
import com.example.pokemon.data.repository.PokemonRepository
import java.util.concurrent.Flow

class PokemonListViewModel(
    private val pokemonRepository: PokemonRepository
): ViewModel() {

//    fun getPokemons(searchString: String?): List<PokemonResult> {
//        var result = pokemonRepository.getPokemon(searchString)
//        return result
//    }
}