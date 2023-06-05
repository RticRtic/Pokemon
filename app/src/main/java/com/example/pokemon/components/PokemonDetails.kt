package com.example.pokemon.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokemon.api_service.model.Pokemon
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

    Scaffold {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.Red)) {
            Row(modifier = Modifier.align(Alignment.TopStart)) {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")}
                Text(text = pokemonName?.uppercase() ?: "Loading ....", modifier = Modifier.padding(top = 8.dp), style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Start, color = Color.White))
            }

            Column(modifier = Modifier.align(Alignment.Center)) {
                Row() {
                    Sprite(url = sprites?.front_shiny ?: "")
                    Sprite(url = sprites?.back_shiny ?: "")
                }

            }

//            Row(modifier = Modifier.align(Alignment.BottomStart)) {
//                Column() {
//                    stats?.forEach { stat ->
//                        Text(text = stat.stat.name, modifier = Modifier.padding(top = 8.dp), style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Start, color = Color.White))
//                    }
//                }
//            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(stats?.size ?: 0) { index ->
                        val stat = stats?.get(index)
                        Box(modifier = Modifier
                            .size(width = 100.dp, height = 100.dp)
                            .padding(8.dp)
                            .background(Color.Blue, RoundedCornerShape(10))) {
                            Box(Modifier.fillMaxSize().padding(horizontal = 5.dp), contentAlignment = Alignment.CenterStart) {
                                Text(text = stat?.stat?.name ?: "", style = TextStyle(color = Color.White, fontSize = 17.sp))
                            }
                            Box(Modifier.fillMaxSize().padding(horizontal = 5.dp), contentAlignment = Alignment.CenterEnd) {
                                Text(text = stat?.base_stat.toString(), style = TextStyle(color = Color.White, fontSize = 17.sp))
                            }
                        }
                    }
                }
            }
        }
    }
}

