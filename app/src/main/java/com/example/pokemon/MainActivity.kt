package com.example.pokemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.api_service.model.Pokemon
import com.example.pokemon.api_service.model.PokemonSprite
import com.example.pokemon.data.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val TAG = "!!!"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            main()
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
        while (true) {
            val pokemonList = repository.getPokemons()
            if (pokemonList.isEmpty()) {
                break
            }
            pokemonList.forEach { pokemon ->
                Log.d(TAG, "Pokemon: ${pokemon.name}")
                Log.d(TAG, "Pokemon: ${pokemon.sprites}")
            }
        }


    }
}
