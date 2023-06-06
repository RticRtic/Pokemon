package com.example.pokemon.api_service.model.pokemon

import android.os.Parcelable
import com.example.pokemon.api_service.model.evolvedPokemon.EvolutionSpecies
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val sprites: PokemonSprite,
    val id: Int,
    val stats: List<Stats>,
    val height: Int,
    val weight: Int,
    val abilities: List<Ability>,
    val evolvedForms: List<EvolutionSpecies>

    ): Parcelable
