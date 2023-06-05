package com.example.pokemon.api_service.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val sprites: PokemonSprite,
    val id: Int,
    val stats: List<Stats>
    ): Parcelable