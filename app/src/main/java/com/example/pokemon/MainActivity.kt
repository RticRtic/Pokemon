package com.example.pokemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.components.showPokemons
import com.example.pokemon.data.repository.PokemonRepository
import com.example.pokemon.viewmodels.PokemonListViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val TAG = "!!!"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showPokemons()
        }
    }

    private fun main() {
        runBlocking {
            launch {
                getPokemons()
            }
        }
    }

    private suspend fun getPokemons() {
        val repository = PokemonRepository(RetrofitInstance.api)
        val pokemons = repository.getPokemons()
        pokemons.forEach { pokemon ->
            Log.d(TAG, "getPokemons: ${pokemon.name}")
            Log.d(TAG, "getPokemons: ${pokemon.sprites.front_shiny}")
        }
    }
}

//while (true) {
//    val pokemonList = repository.getPokemons()
//    if (pokemonList.isEmpty()) {
//        break
//    }
//    pokemonList.forEach { pokemon ->
//        Log.d(TAG, "Pokemon: ${pokemon.name}")
//        Log.d(TAG, "Pokemon: ${pokemon.sprites}")
//    }
//}


