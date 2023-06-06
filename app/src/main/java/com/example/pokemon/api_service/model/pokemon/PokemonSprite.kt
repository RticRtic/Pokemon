package com.example.pokemon.api_service.model.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PokemonSprite(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
): Parcelable