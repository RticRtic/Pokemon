package com.example.pokemon.api_service.model.pokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FlavorTextEntry(
    val flavor_text: String,
    val language: Language,
): Parcelable
