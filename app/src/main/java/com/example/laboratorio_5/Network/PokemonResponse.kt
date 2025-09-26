package com.example.laboratorio_5.Network

data class PokemonListResponse(
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
) {
    val id: Int
        get() = url.split("/").dropLast(1).last().toInt()

    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}

data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites
)

data class Sprites(
    val front_default: String?,
    val front_shiny: String?,
    val back_default: String?,
    val back_shiny: String?
)