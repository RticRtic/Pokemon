package com.example.pokemon.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionSpecies
import com.example.pokemon.api_service.model.pokemon.Ability
import com.example.pokemon.api_service.model.pokemon.Pokemon
import com.example.pokemon.viewmodels.PokemonDetailsViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetails(navController: NavController, pokemonId: Int) {
    val viewModel: PokemonDetailsViewModel = viewModel()
    val pokemonDetailState = remember {
        mutableStateOf<Pokemon?>(null)
    }
    LaunchedEffect(pokemonId) {
        viewModel.fetchPokemonDetails(pokemonId)
    }

    LaunchedEffect(viewModel.pokemonDetails) {
        viewModel.pokemonDetails.collect { pokemon ->
            pokemonDetailState.value = pokemon
        }
    }


    val pokemon = pokemonDetailState.value
    val pokemonName = pokemon?.name
    val sprites = pokemon?.sprites
    val stats = pokemon?.stats
    val pokemonHeight = pokemon?.height
    val pokemonWeight = pokemon?.weight
    val pokemonAbilities: List<Ability>? = pokemon?.abilities
    val evolvedForms: List<EvolutionSpecies>? = pokemon?.evolvedForms


    evolvedForms?.forEach { pokemon ->
        Log.d(TAG, "PokemonDetails: ${pokemon.sprite}")
    }

    val roundedBottomCornerShape = RoundedCornerShape(
        topStart = CornerSize(0.dp),
        topEnd = CornerSize(0.dp),
        bottomStart = CornerSize(50.dp),
        bottomEnd = CornerSize(50.dp)
    )

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(setRandomColor(), shape = roundedBottomCornerShape)
                .border(1.dp, Color.Black, roundedBottomCornerShape)
        ) {
            Row(modifier = Modifier.align(Alignment.TopStart)) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(
                    text = pokemonName?.uppercase() ?: "Loading ....",
                    modifier = Modifier.padding(top = 8.dp),
                    style = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start,
                        color = Color.White
                    )
                )
            }

            Column(modifier = Modifier.align(Alignment.Center)) {
                Row() {
                    Sprite(
                        url = sprites?.front_shiny ?: "",
                        modifier = Modifier.size(height = 200.dp, width = 200.dp)
                    )
                    Sprite(
                        url = sprites?.back_shiny ?: "",
                        modifier = Modifier.size(height = 200.dp, width = 200.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    pokemonHeight?.toString()?.let { height ->
                        Text(
                            "Height: $height",
                            style = TextStyle(color = Color.White)
                        )
                    }
                    pokemonWeight?.toString()?.let { weight ->
                        Text(
                            "Weight: $weight",
                            style = TextStyle(color = Color.White)
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 50.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp)
                ) {
                    Row(modifier = Modifier.align(Alignment.Center)) {
                        Text(
                            text = "Evolved Forms",
                            style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                        )
                    }
                }

//                    pokemonAbilities?.forEach { ability ->
//                       LazyVerticalGrid(columns = GridCells.Fixed(2)) {
//                           items(pokemonAbilities.size) { index ->
//                               val abilities = pokemonAbilities[index]
//                               Box(
//                                   modifier = Modifier
//                                       .size(width = 50.dp, height = 50.dp)
//                                       .padding(8.dp)
//                                       .background(
//                                           color = Color.DarkGray,
//                                           shape = RoundedCornerShape(10.dp)
//                                       )
//                               ) {
//                                   Box(
//                                       Modifier
//                                           .fillMaxSize()
//                                           .padding(horizontal = 5.dp),
//                                       contentAlignment = Alignment.CenterStart
//                                   ) {
//                                       Text(
//                                           text = abilities.ability.name,
//                                           style = TextStyle(color = Color.White, fontSize = 17.sp)
//                                       )
//                                       Log.d(TAG, "PokemonDetails: ${ability.ability.name}")
//                                   }
//                               }
//                           }
//                       }
//                    }
//                }

                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(stats?.size ?: 0) { index ->
                        val stat = stats?.get(index)
                        Box(
                            modifier = Modifier
                                .size(width = 100.dp, height = 100.dp)
                                .padding(8.dp)
                                .background(
                                    color = Color.DarkGray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 5.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Text(
                                    text = stat?.stat?.name ?: "",
                                    style = TextStyle(color = Color.White, fontSize = 17.sp)
                                )
                            }
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 5.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    text = stat?.base_stat.toString(),
                                    style = TextStyle(color = Color.White, fontSize = 17.sp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

