package com.example.pokemon

import com.example.pokemon.data.repository.PokemonRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.api_service.RetrofitInstance
import com.example.pokemon.components.util.NavGraph


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


