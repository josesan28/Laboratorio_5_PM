package com.example.laboratorio_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_5.ui.theme.Laboratorio_5Theme
import com.example.laboratorio_5.Network.Pokemon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio_5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonApp()
                }
            }
        }
    }
}

@Composable
fun PokemonApp() {
    val navController = rememberNavController()
    var selectedPokemon by remember { mutableStateOf<Pokemon?>(null) }

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainFragment(
                onPokemonClick = { pokemon ->
                    selectedPokemon = pokemon
                    navController.navigate("detail")
                }
            )
        }
        composable("detail") {
            selectedPokemon?.let { pokemon ->
                DetailFragment(
                    pokemon = pokemon,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}