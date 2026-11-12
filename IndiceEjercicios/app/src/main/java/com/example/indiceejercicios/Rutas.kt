package com.example.indiceejercicios

sealed class Rutas (val ruta:String){
    object Indice : Rutas("indice")
    object Bandera : Rutas("bandera")
    object Html5 : Rutas("html5")
    object Mondrian : Rutas("mondrian")
    object Tarjeta : Rutas("tarjeta")
    object Pantalla : Rutas("pantalla")
    object Tarjeta2 : Rutas("tarjeta2")
    object CabeceraPerfil : Rutas("cabeceraPerfil")
    object ConfirmaciónCompra : Rutas("confirmaciónCompra")
    object CabeceraProducto : Rutas("cabeceraProducto")
    object SelectorAvatar : Rutas("selectorAvatar")
    object PantallaInicio : Rutas("pantallaInicio")
    object Calculadora : Rutas("calculadora")
}