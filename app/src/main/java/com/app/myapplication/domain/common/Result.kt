package com.app.myapplication.domain.common

// Aqui definimos los estados de respuestra de nuestra API, y manejar
// la interfaz según el resultado, loading,success,error, etc. Un When
sealed class Result<out T> {
    // Loading nunca tendrá un valor T, ni siquiera null
    object Loading : Result<Nothing>()

    data class Success<T>(
        val data: T,
    ) : Result<T>()

    data class Error(
        val exception: Throwable,
        // Podemos añadir un mensaje de error personalizado
        // Nothing= "Nunca retorna un valor"
    ) : Result<Nothing>()
}
