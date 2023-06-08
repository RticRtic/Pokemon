package com.example.pokemon.components.color
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun PokemonBackgroundColor(color: String?): Color {
    return if (color.isNullOrEmpty()) {
        Color.Gray
    } else {
        when (color) {
            "red" -> Color(0xffC04000)
            "blue" ->  Color(0xff3B9C9C)
            "yellow" -> Color(0xffE9AB17)
            "green" -> Color(0xff9CB071)
            "black" -> Color(0xff000000)
            "brown" -> Color(0xff8B4513)
            "purple" -> Color(0xffC38EC7)
            "gray" -> Color(0xff93917C)
            "white" -> Color(0xffFAF5EF)

            else -> Color.LightGray
        }
    }


}

