package com.example.pokemon.viewmodels

import com.example.pokemon.data.repository.PokemonRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.api_service.model.pokemon.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonDetailsViewModel: ViewModel() {

    private val repository = PokemonRepository(RetrofitInstance.api)
    private val _pokemonDetails = MutableStateFlow<Pokemon?>(null)
    val pokemonDetails: StateFlow<Pokemon?> = _pokemonDetails

    fun fetchPokemonDetails(id: Int) {
        viewModelScope.launch {
            val pokemon = repository.getSinglePokemon(id)
            _pokemonDetails.value = pokemon
        }
    }
}