package com.example.pokemon.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.api_service.model.Pokemon
import com.example.pokemon.api_service.model.PokemonResult
import com.example.pokemon.data.repository.PokemonRepository
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class PokemonListViewModel(): ViewModel() {

    private val repository = PokemonRepository(RetrofitInstance.api)
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    fun fetchPokemons() {
        viewModelScope.launch {
            val pokemons = repository.getPokemons()
            _pokemonList.value = pokemons
        }
    }



}