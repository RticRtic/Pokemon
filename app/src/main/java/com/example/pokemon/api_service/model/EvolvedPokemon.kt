package com.example.pokemon.api_service.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EvolvedPokemon(
    val id: Int,
    val name: String,
//    val stats: List<Stats>,
//    val sprites: PokemonSprite,
): Parcelable
