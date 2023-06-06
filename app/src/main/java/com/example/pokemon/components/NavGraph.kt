package com.example.pokemon.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokemon.components.pokemonDetails.PokemonDetails
import com.example.pokemon.data.repository.PokemonRepository

@Composable

fun NavGraph(navController: NavHostController, repository: PokemonRepository) {
    NavHost(navController, startDestination = "pokemonList") {
        composable("pokemonList") { ShowPokemons(navController, repository)}
        composable("pokemonDetails/{pokemonId}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toInt()
            pokemonId?.let { id ->
                PokemonDetails(navController, id)
            }
        }
    }
}