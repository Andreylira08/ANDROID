package com.app.myapplication.domain.model

// Ventajas de usar data class:
//
//    Menos código boilerplate: No necesitas escribir manualmente métodos comunes
// Inmutabilidad por defecto: Al usar val, los campos son inmutables
// Funcionalidad de copia: El método copy() permite crear variantes fácilmente
// Destructuración: Puedes descomponer objetos en variables
//
// // Con una data class
// data class Pokemon(val name: String, val type: String)
//
// val bulbasaur = Pokemon("Bulbasaur", "Grass")
// val (name, type) = bulbasaur  // Destructuración
// val ivysaur = bulbasaur.copy(name = "Ivysaur")  // Copia modificada
// println(bulbasaur)  // Impresión legible automática
data class Pokemon(
    val id: String,
    val name: String,
    val imageUrl: String,
    val weight: Int,
    val height: Int,
    val types: List<String>,
) {
    companion object {
        // Esto es accesible como Pokemon.getMockData()
        fun getMockData(): List<Pokemon> =
            listOf(
                Pokemon(
                    id = "1",
                    name = "Bulbasaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                    weight = 69,
                    height = 7,
                    types = listOf("grass", "poison"),
                ),
                Pokemon(
                    id = "2",
                    name = "Ivysaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
                    weight = 130,
                    height = 10,
                    types = listOf("grass", "poison"),
                ),
                // Agregar más Pokémon mock...
            )
    }
}
