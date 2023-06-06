package com.example.pokemon.api_service.model.evolvedPokemon

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EvolutionChain(
    val evolves_to: List<EvolutionChain>,
    val species: EvolutionSpecies?
): Parcelable
