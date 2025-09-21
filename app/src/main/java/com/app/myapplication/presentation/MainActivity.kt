package com.app.myapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.myapplication.presentation.navigation.PokemonNavGraph
import com.app.myapplication.presentation.theme.INICIANDOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContent es donde definimosel contenido de Compose
        setContent {
            // THEME envuelve toda la UI y proporciona
            // Colores consistentes
            // Tipografía consistente
            // Formas
            // Otro estilos de Material Design
            INICIANDOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokemonNavGraph()
                }
            }
        }
    }
}
