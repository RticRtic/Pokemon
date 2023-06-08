package com.example.pokemon.components.util

import com.example.pokemon.data.repository.PokemonRepository
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokemon.components.pokemonDetails.PokemonDetails
import com.example.pokemon.components.showPokemons.ShowPokemonsView


@Composable

fun NavGraph(navController: NavHostController, repository: PokemonRepository) {
    NavHost(navController, startDestination = "pokemonList") {
        composable("pokemonList") { ShowPokemonsView(navController, repository) }
        composable("pokemonDetails/{pokemonId}") { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toInt()
            pokemonId?.let { id ->
                PokemonDetails(navController, id)
            }
        }
    }
}