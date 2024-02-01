package com.esaka.pokdex.network

import com.esaka.pokdex.model.Pokemon
import com.esaka.pokdex.model.Resource
import com.esaka.pokdex.model.PokemonsListResponse
import java.io.IOException

class Repository {

    suspend fun getPokemonList() : Resource<PokemonsListResponse> {
            val response = try {
                RetrofitFactory.getClient().create(PokeApiService::class.java).getPokemonList()
            }catch (e: Exception) {
                if(e is IOException) return Resource.Error("Please check your connection.")
                else return Resource.Error("An error has occured, please try again later")
            }
            return Resource.Success(response)
    }

    suspend fun getPokemonDetails(pokemonName: String): Resource<Pokemon> {
        val response = try {
            RetrofitFactory.getClient().create(PokeApiService::class.java).getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            if(e is IOException) return Resource.Error("Please check your connection.")
            else return Resource.Error("An error has occured, please try again later")
        }

        return Resource.Success(response)
    }


}