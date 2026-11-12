package com.example.indiceejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.indiceejercicios.ui.theme.IndiceEjerciciosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndiceEjerciciosTheme {
                NavegacionEjercicios()
            }
        }
    }
}

// 1. Creamos el GPS de navegación
@Composable
fun NavegacionEjercicios() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.Indice.ruta
    ) {
        // Ruta incial: Pantalla Índice
        composable(Rutas.Indice.ruta) {
            Indice(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla Bandera
        composable(Rutas.Bandera.ruta) {
            Bandera(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla HTML5
        composable(Rutas.Html5.ruta) {
            Html5(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla Mondrian
        composable(Rutas.Mondrian.ruta) {
            Mondrian(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla Tarjeta
        composable(Rutas.Tarjeta.ruta) {
            Tarjeta(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla Pantalla
        composable(Rutas.Pantalla.ruta) {
            Pantalla(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla Tarjeta2
        composable(Rutas.Tarjeta2.ruta) {
            Tarjeta2(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla CabeceraPerfil
        composable(Rutas.CabeceraPerfil.ruta) {
            CabeceraPerfil(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla CabeceraProducto
        composable(Rutas.CabeceraProducto.ruta) {
            CabeceraProducto(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla SelectorAvatar
        composable(Rutas.SelectorAvatar.ruta) {
            SelectorAvatar(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla PantallaInicio
        composable(Rutas.PantallaInicio.ruta) {
            PantallaInicio(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
        // Ruta: Pantalla Calculadora
        composable(Rutas.Calculadora.ruta) {
            Calculadora(
                onNavigateTo = { ruta ->
                    navController.navigate(ruta)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndiceEjerciciosTheme {
        NavegacionEjercicios()
    }
}