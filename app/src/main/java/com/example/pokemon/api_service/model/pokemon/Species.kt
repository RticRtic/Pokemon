package com.example.pokemon.api_service.model.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Species(
    val name: String,
    var url: String,
    val flavor_text_entries: List<FlavorTextEntry>,
    val language: Language,
    val habitat: Habitat?,
    val color: PokemonColor?,
): Parcelable
