package com.esaka.pokdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.esaka.pokdex.ui.screens.PokemonDetailScreen
import com.esaka.pokdex.ui.screens.PokemonListScreen
import com.esaka.pokdex.ui.theme.PokédexTheme
import com.esaka.pokdex.viewmodels.PokemonDetailsViewModel
import com.esaka.pokdex.viewmodels.PokemonListViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokédexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "pokemon_list_screen"
                    ) {
                        composable("pokemon_list_screen") {
                            PokemonListScreen(
                                navController = navController,
                                modifier = Modifier,
                                viewModel = PokemonListViewModel()
                            )
                        }

                        composable(
                            "pokemon_details_screen/{pokemonName}",
                            arguments = listOf(
                                navArgument("pokemonName") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val pokemonName = remember {
                                it.arguments?.getString("pokemonName")
                            }

                            PokemonDetailScreen(
                                pokemonName = pokemonName!!,
                                navController = navController,
                                viewModel = PokemonDetailsViewModel()
                            )
                        }
                    }
                }
            }
        }
    }


}

