package com.example.pokemon.viewmodels

import com.example.pokemon.data.repository.PokemonRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.api_service.model.pokemon.Pokemon
import kotlinx.coroutines.launch

class PokemonListViewModel() : ViewModel() {

    private val repository = PokemonRepository(RetrofitInstance.api)

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    fun fetchPokemons() {
        viewModelScope.launch {
            val pokemons = repository.pokemons()
            val currentPokemons = _pokemonList.value.orEmpty()
            _pokemonList.value = currentPokemons + pokemons

        }
    }


}

