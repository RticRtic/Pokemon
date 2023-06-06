package com.example.pokemon.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
fun setRandomColor(): Color {
    return remember { randomColor() }
}
private fun randomColor(): Color {
    val excludedColors = listOf(
       Color.White
    )
    var generatedColor: Color

    do {
        generatedColor = Color(
            red = Random.nextInt(256),
            green = Random.nextInt(256),
            blue = Random.nextInt(256)
        )
    } while (generatedColor in excludedColors)

    return generatedColor
}

