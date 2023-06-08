package com.example.pokemon.components.showPokemons

import android.annotation.SuppressLint
import com.example.pokemon.data.repository.PokemonRepository
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemon.viewmodels.PokemonListViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
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
import com.example.pokemon.components.SearchTextField
import com.example.pokemon.components.util.Sprite
import com.example.pokemon.components.util.color.PokemonBackgroundColor
import com.example.pokemon.components.util.color.SurfaceColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowPokemonsView(navController: NavController, repository: PokemonRepository) {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemonListState = viewModel.pokemonList.observeAsState(initial = emptyList())
    val pokemonList = pokemonListState.value
    val searchTextState = remember { mutableStateOf("") }

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xffEBDDE2),
        ) {}

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
                    SearchTextField(
                        searchTextState.value,
                        onValueChanged = { searchTextState.value = it })
                    val filteredPokemonList = pokemonList.filter {
                        it.name.contains(
                            searchTextState.value,
                            ignoreCase = true
                        )
                    }

                    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                        items(filteredPokemonList.size) { pokemon ->
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .background(
                                        color = PokemonBackgroundColor(color = filteredPokemonList[pokemon].color),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.Black,
                                        shape = RoundedCornerShape(8.dp)
                                    )

                                    .clickable {
                                        val pokemonData = filteredPokemonList[pokemon]
                                        navController.navigate("pokemonDetails/${pokemonData.id}")
                                    },
                                contentAlignment = Alignment.Center,

                                ) {

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Sprite(
                                        url = filteredPokemonList[pokemon].sprites.other?.home?.front_default
                                            ?: ""
                                    )
                                    Text(
                                        text = filteredPokemonList[pokemon].name.uppercase(),
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
}




