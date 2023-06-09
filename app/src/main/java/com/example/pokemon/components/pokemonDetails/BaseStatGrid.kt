package com.example.pokemon.components.pokemonDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.ShieldMoon
import androidx.compose.material.icons.filled.ShutterSpeed
import androidx.compose.material.icons.filled.SportsMartialArts
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemon.api_service.model.pokemon.Stats

@Composable
fun BaseStatGrid (stats: List<Stats>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(stats.size) { index ->
            val stat = stats[index]

            val iconHeart = index == 0
            val iconStar = index == 1
            val iconShield = index == 2
            val iconSpecialAttack = index == 3
            val iconSpecialDefense = index == 4
            val iconSpeed = index == 5

            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .padding(8.dp)
                    .border(1.dp, Color.White, RoundedCornerShape(100.dp))
                    .background(
                        color = Color(0xff657383),
                        shape = RoundedCornerShape(100.dp)

                    ),
                contentAlignment = Alignment.Center

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (iconHeart) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Hp",
                            tint = Color(0xffC24641)
                        )
                    }
                    if (iconStar) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = "Attack",
                            tint = Color(0xffFFCE44)
                        )
                    }
                    if (iconShield) {
                        Icon(
                            Icons.Default.Shield,
                            contentDescription = "Defense",
                            tint = Color(0xff4E5180)
                        )
                    }
                    if (iconSpecialDefense) {
                        Icon(
                            Icons.Default.ShieldMoon,
                            contentDescription = "Special Defense",
                            tint = Color(0xff2E1A47)
                        )
                    }
                    if (iconSpecialAttack) {
                        Icon(
                            Icons.Default.SportsMartialArts,
                            contentDescription = "Special Attack",
                            tint = Color(0xffF0E68C)
                        )
                    }
                    if (iconSpeed) {
                        Icon(
                            Icons.Default.ShutterSpeed,
                            contentDescription = "Speed",
                            tint = Color(0xff00FF7F)
                        )
                    }
                    Text(
                        text = stat.stat.name,
                        style = TextStyle(color = Color.White, fontSize = 17.sp),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = stat.base_stat.toString(),
                        style = TextStyle(color = Color.White, fontSize = 17.sp)
                    )

                }
            }
        }
    }
}