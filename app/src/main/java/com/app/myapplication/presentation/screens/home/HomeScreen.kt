package com.app.myapplication.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.myapplication.domain.model.Pokemon
import com.app.myapplication.presentation.screens.home.components.PokemonListContent
import com.app.myapplication.presentation.screens.home.components.PokemonListTab
import com.app.myapplication.presentation.screens.home.components.SearchTab

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onPokemonClick: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    // En compose utilizaremos el manejo de estados, un concepto que se asemeja a REACT. Estos estados
    // Actualizan en tiempo real los valores de las variables
    // mutableStateOf es el sensor que dectarara un cambio en el movimiento y la interfaz reaccionara
    // Por ejemplo, si tienes una lampara con un sensor de movimiento   La lámpara es tu interfaz El sensor es mutableStateOf Cuando detecta un cambio (movimiento), la lámpara reacciona (se enciende)

    // Remember es la memora a corto plazo que recordara el valor del sensor, sin ella la aplicacion se reiniciaria cada vez que esta se actualice

    // Utilizamos by para acceder a la informacion que recordamos

    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Pokémon List", "Search")
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            // Barra superior de la aplicación, centra el título automáticamente
            // Aqui puedes incluir acciones,menus y navegación. Por ahora solo el título
            CenterAlignedTopAppBar(
                title = { Text("Pokédex") },
            )
        },
    ) { padding ->
        // Organiza los elementos verticalmente
        Column(
            modifier =
                Modifier
                    // Equivalente en HTML a size: 100%
                    .fillMaxSize()
                    .padding(padding),
        ) {
            // Contenedor para las pestañas
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                    )
                }
            }

            when (selectedTabIndex) {
                0 ->
                    PokemonListContent(
                        pokemonList = uiState.pokemonList,
                        isLoading = uiState.isLoading,
                        error = uiState.error,
                        onPokemonClick = onPokemonClick,
                    )
                1 -> SearchTab(onPokemonClick = onPokemonClick)
            }
        }
    }
}
