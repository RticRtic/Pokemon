package com.example.pokemon.api_service.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PokemonResponse(
    val results: List<PokemonResult>,
    val count: Int,
    val next: String?,
    val previous: String?
): Parcelable