package com.example.pokemon.components.pokemonDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokemon.api_service.model.pokemon.Ability
import com.example.pokemon.api_service.model.pokemon.Pokemon
import com.example.pokemon.components.util.color.surfaceColor
import com.example.pokemon.viewmodels.PokemonDetailsViewModel
val TAG = "!!!"
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetails(navController: NavController, pokemonId: Int) {
    val viewModel: PokemonDetailsViewModel = viewModel()
    val pokemonDetailState = remember {
        mutableStateOf<Pokemon?>(null)
    }

    val pokemon = pokemonDetailState.value
    val pokemonName = pokemon?.name
    val sprites = pokemon?.sprites
    val stats = pokemon?.stats
    val pokemonHeight = pokemon?.height
    val pokemonWeight = pokemon?.weight
    val pokemonAbilities: List<Ability>? = pokemon?.abilities
    val habitat = pokemon?.habitat
    val color = pokemon?.color

    LaunchedEffect(pokemonId) {
        viewModel.fetchPokemonDetails(pokemonId)
    }

    LaunchedEffect(viewModel.pokemonDetails) {
        viewModel.pokemonDetails.collect { pokemon ->
            pokemonDetailState.value = pokemon
        }
    }


    val roundedBottomCornerShape = RoundedCornerShape(
        topStart = CornerSize(0.dp),
        topEnd = CornerSize(0.dp),
        bottomStart = CornerSize(50.dp),
        bottomEnd = CornerSize(50.dp)
    )

    Scaffold {


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = surfaceColor(color = color ?: ""),
        ) {

        }

            DroppedDownToolBar(
                roundedBottomCornerShape = roundedBottomCornerShape,
                navController = navController,
                pokemonName = pokemonName ?: "",
                sprites = sprites ?: return@Scaffold,
                pokemonHeight = pokemonHeight ?: 0,
                pokemonWeight = pokemonWeight ?: 0,
                habitat = habitat ?: "",
                color = color ?: ""
            )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                AbilitiesBox(pokemonAbilities ?: emptyList(), pokemon)
                Spacer(modifier = Modifier.height(10.dp))
                BaseStatGrid(stats = stats ?: emptyList())
            }
        }
    }
}

