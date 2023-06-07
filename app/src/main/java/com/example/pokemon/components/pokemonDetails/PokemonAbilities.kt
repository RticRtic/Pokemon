package com.example.pokemon.components.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.api_service.model.pokemon.Ability

@Composable
fun PokemonAbilities(pokemonAbilities: List<Ability>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(pokemonAbilities.size) { index ->
            val abilities = pokemonAbilities[index]
            val firstAttack = index == 0
            val secondAttack = index == 1
            val thirdAttack = index == 2
            val fourthAttack = index == 3

            Box(
                modifier = Modifier
                    .size(width = 50.dp, height = 50.dp)
                    .padding(start = 5.dp, top = 10.dp, end = 4.dp, bottom = 5.dp)
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(0.dp, 0.dp, 30.dp, 30.dp)
                    ),
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.CenterStart
                ) {

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = abilities.ability.name,
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 17.sp,
                                textAlign = TextAlign.Center
                            )
                        )

                        if (firstAttack) {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Hp",
                                tint = Color.Red
                            )
                        }
                    }
                }
            }
        }
    }
}
