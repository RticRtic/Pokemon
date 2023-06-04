package com.example.pokemon.api_service.model

data class PokemonResponse(
    val results: List<PokemonResult>,
    val count: Int,
    val next: String?,
    val previous: String?
)