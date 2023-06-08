package com.example.pokemon.api_service.model.pokemon

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class PokemonSprite(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String,
    val other: Other?
) : Parcelable


@Parcelize
data class Other(
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork,
    val home: Home,
) : Parcelable

@Parcelize
data class OfficialArtwork(
    val front_default: String
) : Parcelable

@Parcelize
data class Home(
    val front_default: String,
    val back_default: String,
) : Parcelable