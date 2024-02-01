package com.esaka.pokdex.viewmodels

import androidx.lifecycle.ViewModel
import com.esaka.pokdex.model.Pokemon
import com.esaka.pokdex.model.Resource
import com.esaka.pokdex.network.Repository

class PokemonDetailsViewModel : ViewModel() {

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {
        return Repository().getPokemonDetails(pokemonName)
    }
}