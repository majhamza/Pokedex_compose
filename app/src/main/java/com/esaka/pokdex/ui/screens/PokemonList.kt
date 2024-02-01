package com.esaka.pokdex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esaka.pokdex.model.PokemonEntries
import com.esaka.pokdex.viewmodels.PokemonListViewModel

@Composable
fun PokemonListScreen(
    navController: NavController,
    modifier: Modifier,
    viewModel: PokemonListViewModel
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {

        val pokemonList by remember { viewModel.pokemonList}
        val loadError by remember { viewModel.loadError }
        val isLoading by remember { viewModel.isLoading }

        LazyColumn() {
            items(pokemonList) { pokemon ->
                PokemonListItem(
                    navController = navController,
                    modifier = Modifier,
                    data = pokemon
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if(isLoading) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
            if(loadError.isNotEmpty()) {
                RetrySection(error = loadError)
            }
        }

    }

}

@Composable
fun PokemonListItem(
    navController: NavController,
    modifier: Modifier,
    data: PokemonEntries
) {

    Column(modifier = modifier.padding(10.dp)) {
        Box(
            modifier = Modifier
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(70.dp)
                .aspectRatio(1f)
                .background(
                   MaterialTheme.colorScheme.primary
                )
                .clickable {
                    navController.navigate("pokemon_details_screen/${data.pokemonSpecies?.name}")

                }
        ) {

            Text(
                modifier = Modifier
                    .align(CenterStart)
                    .padding(start = 5.dp),
                text = data.pokemonSpecies?.name!!.replaceFirstChar(Char::titlecase),
                fontSize = 20.sp,
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .align(CenterEnd)
                    .padding(end = 5.dp),
                text = "#" + data.entryNumber.toString(),
                fontSize = 20.sp,
                color = Color.White
            )

        }
    }
}

@Composable
fun RetrySection(
    error: String,
) {
    Column {
        Text(error, color = Color.Red, fontSize = 18.sp)
    }
}
