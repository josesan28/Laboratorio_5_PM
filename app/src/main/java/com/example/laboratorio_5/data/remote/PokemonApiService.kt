package com.example.laboratorio_5.data.remote

import com.example.laboratorio_5.Network.PokemonDetail
import com.example.laboratorio_5.Network.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon?limit=100")
    suspend fun getPokemonList(): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetail
}