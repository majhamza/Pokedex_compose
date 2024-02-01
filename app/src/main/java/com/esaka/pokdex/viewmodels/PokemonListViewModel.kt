package com.esaka.pokdex.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esaka.pokdex.model.Resource
import com.esaka.pokdex.model.PokemonEntries
import com.esaka.pokdex.network.Repository
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    var pokemonList = mutableStateOf<List<PokemonEntries>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        getPokemonList()
    }

    fun getPokemonList(){
        viewModelScope.launch{
            isLoading.value = true
            val result = Repository().getPokemonList()

            when(result){
                is Resource.Success ->{
                    pokemonList.value = result.data!!.pokemonEntries
                    isLoading.value = false
                }

                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }

                is Resource.Loading -> {
                }
            }
        }
    }
}