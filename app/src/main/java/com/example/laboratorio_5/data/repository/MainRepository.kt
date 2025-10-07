package com.example.laboratorio_5.data.repository

import com.example.laboratorio_5.Network.Pokemon
import com.example.laboratorio_5.Network.PokemonDetail
import com.example.laboratorio_5.data.remote.PokemonApiService
import com.example.laboratorio_5.data.remote.RetrofitClient

interface PokemonRepository {
    suspend fun getPokemonList(): Result<List<Pokemon>>
    suspend fun getPokemonDetail(id: Int): Result<PokemonDetail>
}

class PokemonRepositoryImpl(
    private val apiService: PokemonApiService = RetrofitClient.apiService
) : PokemonRepository {

    override suspend fun getPokemonList(): Result<List<Pokemon>> {
        return try {
            val response = apiService.getPokemonList()
            Result.success(response.results)
        } catch (e: Exception) {
            Result.failure(
                Exception("No se pudo cargar la lista de Pokémon. Verifica tu conexión.", e)
            )
        }
    }

    override suspend fun getPokemonDetail(id: Int): Result<PokemonDetail> {
        return try {
            val detail = apiService.getPokemonDetail(id)
            Result.success(detail)
        } catch (e: Exception) {
            Result.failure(
                Exception("No se pudo cargar el detalle del Pokémon. Verifica tu conexión.", e)
            )
        }
    }
}