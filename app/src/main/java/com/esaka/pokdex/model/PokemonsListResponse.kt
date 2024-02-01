package com.esaka.pokdex.model


import com.google.gson.annotations.SerializedName


data class PokemonsListResponse(

    @SerializedName("descriptions") var descriptions: ArrayList<Descriptions> = arrayListOf(),
    @SerializedName("id") var id: Int? = null,
    @SerializedName("is_main_series") var isMainSeries: Boolean? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("names") var names: ArrayList<Names> = arrayListOf(),
    @SerializedName("pokemon_entries") var pokemonEntries: ArrayList<PokemonEntries> = arrayListOf(),
    @SerializedName("region") var region: String? = null,
    @SerializedName("version_groups") var versionGroups: ArrayList<String> = arrayListOf()

)