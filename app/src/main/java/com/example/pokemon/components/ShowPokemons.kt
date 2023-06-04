package com.example.pokemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemon.viewmodels.PokemonListViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun showPokemons() {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemonListState = viewModel.pokemonList.observeAsState(initial = emptyList())

    LaunchedEffect(viewModel.pokemonList) {
        viewModel.fetchPokemons()
    }

    val pokemonList = pokemonListState.value

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Sprite(url = "https://i.pinimg.com/originals/d8/43/ad/d843addbfcec31846d8699feebcf358b.png", Modifier.size(100.dp))
        Spacer(modifier = Modifier.height(16.dp))

        if (pokemonList.isNotEmpty()) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(pokemonList.size) { pokemon ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.LightGray, RoundedCornerShape(50.dp))
                            .clickable { },
                        contentAlignment = Alignment.Center,

                        ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Sprite(url = pokemonList[pokemon].sprites.front_default)
                            Text(
                                text = pokemonList[pokemon].name,
                                style = TextStyle(fontSize = 17.sp, textAlign = TextAlign.Center),
                                modifier = Modifier.padding(bottom = 30.dp)
                            )
                        }
                    }
                }
            }
        } else {
            Text("No pokemons found")
        }
    }
}