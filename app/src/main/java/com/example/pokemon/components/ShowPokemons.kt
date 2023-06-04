package com.example.pokemon.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemon.viewmodels.PokemonListViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun showPokemons() {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemonListState = viewModel.pokemonList.observeAsState(initial = emptyList())

    LaunchedEffect(viewModel.pokemonList) {
        viewModel.fetchPokemons()
    }

    val pokemonList = pokemonListState.value

    Column {
        Text("Pokemons")
        Spacer(modifier = Modifier.height(8.dp))

        if (pokemonList.isNotEmpty()) {
            LazyColumn{
                items(pokemonList.size) {pokemon ->
                    Text(pokemonList[pokemon].name)
                }
            }
        } else {
            Text("No pokemons found")
        }
    }
}