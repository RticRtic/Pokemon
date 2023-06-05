package com.example.pokemon.api_service.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Stats(
    val base_stat: Int,
    val effort: Int,
    val stat: Stat
): Parcelable
