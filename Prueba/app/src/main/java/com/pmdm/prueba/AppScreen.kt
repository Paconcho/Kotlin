package com.pmdm.prueba

    sealed class AppScreen(val route: String) {
        object Inicio : AppScreen("pantalla_inicio")
        object EjercicioA : AppScreen("ejercicio_a")
    }
