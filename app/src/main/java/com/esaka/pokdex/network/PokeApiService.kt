package com.esaka.pokdex.network

import com.esaka.pokdex.model.Pokemon
import com.esaka.pokdex.model.PokemonsListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokedex/1/")
    suspend fun getPokemonList(): PokemonsListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

}