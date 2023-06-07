package com.example.pokemon.components

import com.example.pokemon.data.repository.PokemonRepository
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemon.viewmodels.PokemonListViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokemon.api_service.PokemonApi
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionChainResponse


val TAG = "!!!"

@Composable
fun ShowPokemons(navController: NavController, repository: PokemonRepository) {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemonListState = viewModel.pokemonList.observeAsState(initial = emptyList())
    val pokemonList = pokemonListState.value

    LaunchedEffect(viewModel.pokemonList) {
        if (pokemonList.isEmpty()) {
            viewModel.fetchPokemons()
        }
    }

    if (pokemonList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Sprite(
                    url = "https://i.pinimg.com/originals/d8/43/ad/d843addbfcec31846d8699feebcf358b.png",
                    Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(pokemonList.size) { pokemon ->
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .background(
                                        color = setRandomColor(),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .clickable {
                                        val pokemonData = pokemonList[pokemon]
                                        navController.navigate("pokemonDetails/${pokemonData.id}")
                                        Log.d(TAG, "ShowPokemons: ${pokemonData.id}")
                                    },
                                contentAlignment = Alignment.Center,

                                ) {

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Sprite(url = pokemonList[pokemon].sprites.front_shiny)
                                    Text(
                                        text = pokemonList[pokemon].name.uppercase(),
                                        style = TextStyle(
                                            fontSize = 17.sp,
                                            textAlign = TextAlign.Center,
                                            fontWeight = FontWeight.Bold
                                        ),
                                        modifier = Modifier
                                            .background(
                                                Color.White,
                                                RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)
                                            )
                                            .fillMaxWidth()
                                            .height(40.dp)
                                            .padding(top = 8.dp)
                                    )
                                }
                            }
                        }
                        item {
                            viewModel.fetchPokemons()
                        }
                    }
                }
            }
        }
    }


