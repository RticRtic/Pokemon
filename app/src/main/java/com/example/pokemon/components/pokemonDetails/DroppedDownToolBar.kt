package com.example.pokemon.components.pokemonDetails

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokemon.api_service.model.pokemon.PokemonSprite
import com.example.pokemon.components.Sprite
import com.example.pokemon.components.setRandomColor

@Composable
fun DroppedDownToolBar(
    roundedBottomCornerShape: RoundedCornerShape,
    navController: NavController,
    pokemonName: String,
    sprites: PokemonSprite,
    pokemonHeight: Int,
    pokemonWeight: Int,


    ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
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
}