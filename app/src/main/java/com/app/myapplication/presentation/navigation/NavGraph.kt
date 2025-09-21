package com.app.myapplication.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.myapplication.presentation.screens.home.HomeScreen
import com.app.pokedexapp.presentation.screens.detail.PokemonDetailScreen

sealed class Screen(
    // Esta es la clase BASE define una propiedad route que representa ruta de navegación
    // Como es una sealed class solo puede tener las subclases que estan definidas dentro de ella
    val route: String,
) {
    // Aqui un ejemplo de subclases que heredan de screen. Home define una ruta simple "HOME"
    object Home : Screen("home")

    // Hereda Screen Define una ruta con un parámetro {pokemonId}
    object Detail : Screen("pokemon/{pokemonId}") {
        // Incluye una función createRoute que construye la ruta real reemplazando el parámetro con un ID específico
        fun createRoute(pokemonId: String) = "pokemon/$pokemonId"
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun PokemonNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        // Contenedor que maneja todas nuestras pantallas
        navController = navController, // El controlador que maneja la navegación
        startDestination = Screen.Home.route, // Indica qué pantalla se muestra primero
        modifier = modifier, // Para personalizar el aspecto si es necesario
    ) {
        // PRIMERA PANTALLA: Home
        composable(route = Screen.Home.route) {
            // "route" es como la dirección de la pantalla
            HomeScreen(
                onPokemonClick = { pokemonId ->
                    // Que hacer cuando se hace click en un pokemon
                    // Navega a la pantalla de detalles pasando el ID del Pokémon como argumento
                    navController.navigate(Screen.Detail.createRoute(pokemonId))
                },
            )
        }
        composable(
            route = Screen.Detail.route, // La ruta incluye el parametro pokemonID
            arguments =
                listOf(
                    navArgument("pokemonId") {
                        type = NavType.StringType
                    },
                ),
            // Define el tipo de dato es pokemonID
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId") ?: "1"
            PokemonDetailScreen(
                pokemonId = pokemonId, // Pasa el ID a la pantalla
                onBackClick = {
                    // Funcion que realizara cuando se haga click en el boton de regresar
                    navController.popBackStack() // Regresa a la pantalla anterior
                },
            )
        }
    }
}

// PANTALLA DEL BUSCADOR
@Suppress("ktlint:standard:function-naming")
@Composable
fun SearchTab(onPokemonClick: (String) -> Unit) {
    // Nuestro Lienzo Blanco, como en HTML
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            // EN HTML SERÍA EL EQUIVALENTE A <h2> Búsqueda Pokemon <h2>
            text = "Búsqueda de Pokémon",
            style = MaterialTheme.typography.headlineMedium,
        )

        // HTML EQUIVALENTE A <div style= "height: 16px"></div>">
        // dp es una unidad de medida que representa densidad de puntos
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Funcionalidad disponible próximamente",
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
