package com.esaka.pokdex.model

import com.google.gson.annotations.SerializedName


data class Descriptions (

    @SerializedName("description" ) var description : String?   = null,
    @SerializedName("language"    ) var language    : Language? = Language()
)

