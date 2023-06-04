package com.example.pokemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pokemon.components.ShowPokemons

val TAG = "!!!"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           ShowPokemons()
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


