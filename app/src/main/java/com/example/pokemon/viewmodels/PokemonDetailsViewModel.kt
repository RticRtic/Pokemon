package com.example.pokemon.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.api_service.model.Pokemon
import com.example.pokemon.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel: ViewModel() {

    private val repository = PokemonRepository(RetrofitInstance.api)
    private val _pokemonDetails = MutableStateFlow<Pokemon?>(null)
    val pokemonDetails: StateFlow<Pokemon?> = _pokemonDetails

    fun fetchPokemonDetails(pokemonId: Int) {
        viewModelScope.launch {
            val pokemon = repository.getSinglePokemon(pokemonId)
            _pokemonDetails.value = pokemon
        }
    }

    fun getStatNames(pokemon: Pokemon): List<String> {
        return pokemon.stats.map { it.stat.name }
    }

    fun getBaseStats(pokemon: Pokemon): List<Int> {
        return pokemon.stats.map { it.base_stat }
    }

    fun getStatEfforts(pokemon: Pokemon): List<Int> {
        return pokemon.stats.map { it.effort }
    }
}