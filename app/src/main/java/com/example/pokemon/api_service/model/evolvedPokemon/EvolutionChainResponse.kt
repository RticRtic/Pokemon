package com.example.pokemon.api_service.model.evolvedPokemon

import android.os.Parcelable
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionChain
import kotlinx.parcelize.Parcelize

@Parcelize
data class EvolutionChainResponse(
    val chain: EvolutionChain
): Parcelable
