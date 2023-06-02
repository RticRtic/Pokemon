package com.example.pokemon.api_service.model

data class PokemonResponse(val results: List<PokemonResult>)
data class PokemonResult(val pokemonName: String, val url: String)
data class Pokemon(val name: String, val sprites: PokemonSprites)
data class PokemonSprites(val front_default: String)