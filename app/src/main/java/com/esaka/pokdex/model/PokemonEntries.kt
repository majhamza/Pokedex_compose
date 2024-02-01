package com.esaka.pokdex.model

import com.google.gson.annotations.SerializedName


data class PokemonEntries (

  @SerializedName("entry_number"    ) var entryNumber    : Int?            = null,
  @SerializedName("pokemon_species" ) var pokemonSpecies : PokemonSpecies? = PokemonSpecies()

)