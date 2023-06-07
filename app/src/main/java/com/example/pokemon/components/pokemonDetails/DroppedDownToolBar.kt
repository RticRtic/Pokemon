package com.example.pokemon.components.pokemonDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import coil.compose.rememberImagePainter
import com.example.pokemon.api_service.model.pokemon.Ability
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
    pokemonAbilities: List<Ability>


) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .background(setRandomColor(), shape = roundedBottomCornerShape)
            .border(1.dp, Color.Black, roundedBottomCornerShape)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            BoxWithBackgroundImage(url = sprites.other?.officialArtwork?.front_default ?: "")
        }
        Row(modifier = Modifier.align(Alignment.TopStart)) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Text(
                text = pokemonName.uppercase(),
                modifier = Modifier.padding(top = 8.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
            )
        }

        Column(modifier = Modifier
            .align(Alignment.Center)
            .padding(top = 20.dp)) {
            Row {
                Sprite(
                    url = "",
                    modifier = Modifier.size(height = 200.dp, width = 200.dp)
                )
                Sprite(
                    url = "",
                    modifier = Modifier.size(height = 200.dp, width = 200.dp)
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Height: $pokemonHeight", style = TextStyle(color = Color.Black, fontSize = 20.sp))
                    Text(text = "Weight: $pokemonWeight", style = TextStyle(color = Color.Black, fontSize = 20.sp))

                }
            }
        }
    }
}

@Composable
fun BoxWithBackgroundImage(url: String) {
    Box(modifier = Modifier.size(200.dp)) {
        Image(
            painter = rememberImagePainter(data = url),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}