package com.example.pokemon.components.util.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun habitatTextColor(habitat: String) : Color {
    val color = when (habitat) {
        "cave" -> Color.Black
        "forest" -> Color(0xff254117)
        "grassland" -> Color(0xff008000)
        "mountain" -> Color.Black
        "rare" -> Color(0xffFFCE44)
        "rough-terrain" -> Color.Black
        "waters-edge" -> Color(0xff151B54)
        "urban" -> Color(0xffE1D9D1)
        "sea" -> Color(0xff00008B)
        else -> Color.Black
    }
    return color
}