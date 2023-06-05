package com.example.pokemon.api_service.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResult(
    val pokemonName: String,
    val url: String
) : Parcelable