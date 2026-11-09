package com.pmdm.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pmdm.prueba.ui.theme.PruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaTheme() {
                NavegacionApp()
            }
        }
    }
}
@Composable
fun NavegacionApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.Inicio.route
    ) {
        composable(AppScreen.Inicio.route) {
            PantallaInicio(
                onNavigateToEjercicioA = {
                    navController.navigate(AppScreen.EjercicioA.route)
                }
            )
        }
        composable(AppScreen.EjercicioA.route) {
            PantallaEjercicioA(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}