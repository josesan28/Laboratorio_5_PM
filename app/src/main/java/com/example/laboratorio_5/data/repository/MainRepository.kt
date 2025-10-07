package com.example.laboratorio_5.data.repository

import com.example.laboratorio_5.Network.Pokemon
import com.example.laboratorio_5.Network.PokemonDetail
import com.example.laboratorio_5.Network.PokemonApi

interface PokemonRepository {
    suspend fun getPokemonList(): Result<List<Pokemon>>
    suspend fun getPokemonDetail(id: Int): Result<PokemonDetail>
}

class PokemonRepositoryImpl(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemonList(): Result<List<Pokemon>> {
        return try {
            val response = api.getPokemonList()
            Result.success(response.results)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPokemonDetail(id: Int): Result<PokemonDetail> {
        return try {
            val detail = api.getPokemonDetail(id)
            Result.success(detail)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}