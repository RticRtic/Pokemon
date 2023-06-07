package com.example.pokemon

import com.example.pokemon.data.repository.PokemonRepository
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.components.NavGraph
import com.example.pokemon.components.ShowPokemons


val TAG = "!!!"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val repository = PokemonRepository(RetrofitInstance.api)
            NavGraph(navController, repository)
        }
    }
}


