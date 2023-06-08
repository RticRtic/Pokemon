package com.example.pokemon.api_service.model.pokemon

import android.os.Parcelable
import com.example.pokemon.api_service.model.pokemon.Stat
import kotlinx.parcelize.Parcelize


@Parcelize
data class Stats(
    val base_stat: Int,
    val effort: Int,
    val stat: Stat
): Parcelable
