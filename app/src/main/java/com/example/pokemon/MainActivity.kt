package com.example.pokemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.pokemon.api_service.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val TAG = "!!!"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getPokemonList()
        }
    }

    private fun getPokemonList() {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.api.getPokemonList()
            Log.d(TAG, "getPokemonList: ${response.results}")
            if (response.results.isNotEmpty()) {
                val pokemonList = response.results
                pokemonList.forEach {
                    RetrofitInstance.api.getPokemon(it.url)
                    Log.d(TAG, "getPokemonList: ${it.url}")
                }
            }
        }
    }
}
