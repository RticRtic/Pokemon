package com.example.pokemon.components.util.color
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.pokemon.R

@Composable
fun pokemonBackgroundColor(color: String?): Color {
    return if (color.isNullOrEmpty()) {
        Color.Gray
    } else {
        when (color) {
            "red" -> colorResource(id = R.color.background_red)
            "blue" ->  colorResource(id = R.color.background_blue)
            "yellow" -> colorResource(id = R.color.background_yellow)
            "green" -> colorResource(id = R.color.background_green)
            "black" -> colorResource(id = R.color.background_black)
            "brown" -> colorResource(id = R.color.background_brown)
            "purple" -> colorResource(id = R.color.background_purple)
            "gray" -> colorResource(id = R.color.background_gray)
            "white" -> colorResource(id = R.color.background_white)

            else -> Color.LightGray
        }
    }


}

