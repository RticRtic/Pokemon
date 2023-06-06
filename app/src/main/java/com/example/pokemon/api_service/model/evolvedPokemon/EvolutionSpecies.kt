package com.example.pokemon.api_service.model.evolvedPokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EvolutionSpecies(
    val name: String,
    val url: String,
    val id: Int,
    var sprite: String?
): Parcelable
