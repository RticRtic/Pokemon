package com.example.pokemon.components.util.color

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SurfaceColor(color: String?): Color {
    return if (color.isNullOrEmpty()) {
        Color.Gray
    } else {
        when (color) {
            "red" -> Color(0xffCB6D51)
            "blue" ->  Color(0xff92C7C7)
            "yellow" -> Color(0xffF0E68C)
            "green" -> Color(0xff99C68E)
            "black" -> Color(0xff93917C)
            "brown" -> Color(0xffE2A76F)
            "purple" -> Color(0xffECC5C0)
            "gray" -> Color(0xffEBDDE2)
            "white" -> Color(0xffE9E4D4)

            else -> Color.LightGray
        }
    }


}