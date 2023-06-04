package com.example.pokemon.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.api_service.ApiConstants
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.api_service.model.Pokemon
import com.example.pokemon.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonListViewModel() : ViewModel() {

    val TAG = "!!!"

    private val repository = PokemonRepository(RetrofitInstance.api)
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    private var isLoading = false
    var totalPokemonCount = 0

    init {
        fetchPokemons()
    }

    fun fetchPokemons() {
        viewModelScope.launch {
            val pokemons =
                repository.pokemons(ApiConstants.DEFAULT_LIMIT, ApiConstants.DEFAULT_OFFSET)
            _pokemonList.value = pokemons
            totalPokemonCount = pokemons.size

        }
    }

    fun loadMorePokemons() {

            viewModelScope.launch {

                ApiConstants.DEFAULT_OFFSET += ApiConstants.DEFAULT_LIMIT
                val pokemons = repository.pokemons(ApiConstants.DEFAULT_LIMIT, ApiConstants.DEFAULT_OFFSET)
                val currentPokemons = _pokemonList.value.orEmpty()
                _pokemonList.value = currentPokemons + pokemons
                totalPokemonCount += pokemons.size

            }

    }


}