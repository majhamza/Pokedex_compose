package com.esaka.pokdex.model

import com.google.gson.annotations.SerializedName


data class PokemonSpecies (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)