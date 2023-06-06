package com.example.pokemon.components.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionSpecies
import com.example.pokemon.components.Sprite

@Composable
fun EvolvedForms (evolvedForms: List<EvolutionSpecies>?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 2.dp)
    ) {
        Row(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Evolved Forms",
                style = TextStyle(
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(150.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            evolvedForms?.forEach { pokemon ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Sprite(
                        url = pokemon.sprite ?: "",
                        modifier = Modifier
                            .size(height = 100.dp, width = 100.dp)
                    )
                    Text(
                        text = pokemon.name.uppercase(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}