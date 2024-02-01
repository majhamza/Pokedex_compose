package com.esaka.pokdex.model

import com.google.gson.annotations.SerializedName


data class Language (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)