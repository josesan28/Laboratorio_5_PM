package com.example.laboratorio_5

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import com.example.laboratorio_5.Network.Pokemon
import com.example.laboratorio_5.Network.PokemonDetail
import com.example.laboratorio_5.Network.RetrofitClient

class DetailViewModel : ViewModel() {
    private val _pokemonDetail = mutableStateOf<PokemonDetail?>(null)
    val pokemonDetail: State<PokemonDetail?> = _pokemonDetail

    fun loadPokemonDetail(id: Int) {
        viewModelScope.launch {
            try {
                val detail = RetrofitClient.api.getPokemonDetail(id)
                _pokemonDetail.value = detail
            } catch (e: Exception) {
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailFragment(
    pokemon: Pokemon,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel = viewModel()
) {
    val pokemonDetail by viewModel.pokemonDetail

    LaunchedEffect(pokemon.id) {
        viewModel.loadPokemonDetail(pokemon.id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "DetailFragment",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EA)
                )
            )
        }
    ) { paddingValues ->
        pokemonDetail?.let { detail ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Front",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "Back",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = detail.sprites.front_default,
                        contentDescription = "Front normal",
                        modifier = Modifier
                            .size(150.dp)
                            .weight(1f),
                        contentScale = ContentScale.Fit
                    )
                    AsyncImage(
                        model = detail.sprites.back_default,
                        contentDescription = "Back normal",
                        modifier = Modifier
                            .size(150.dp)
                            .weight(1f),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Front Shiny",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "Back Shiny",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AsyncImage(
                        model = detail.sprites.front_shiny,
                        contentDescription = "Front shiny",
                        modifier = Modifier
                            .size(150.dp)
                            .weight(1f),
                        contentScale = ContentScale.Fit
                    )
                    AsyncImage(
                        model = detail.sprites.back_shiny,
                        contentDescription = "Back shiny",
                        modifier = Modifier
                            .size(150.dp)
                            .weight(1f),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

//Preview sin datos

@Composable
@Preview
fun DetailFragmentPreview() {
    DetailFragment(
        pokemon = Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/"),
        onBackClick = {}
    )
}