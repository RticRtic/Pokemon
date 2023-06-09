package com.example.pokemon.components.util.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.pokemon.R

@Composable
fun surfaceColor(color: String?): Color {
    return if (color.isNullOrEmpty()) {
        Color.Gray
    } else {
        when (color) {
            "red" -> colorResource(id = R.color.surface_red)
            "blue" ->  colorResource(id = R.color.surface_blue)
            "yellow" -> colorResource(id = R.color.surface_yellow)
            "green" -> colorResource(id = R.color.surface_green)
            "black" -> colorResource(id = R.color.surface_black)
            "brown" -> colorResource(id = R.color.surface_brown)
            "purple" -> colorResource(id = R.color.surface_purple)
            "gray" -> colorResource(id = R.color.surface_gray)
            "white" -> colorResource(id = R.color.surface_white)

            else -> Color.LightGray
        }
    }


}