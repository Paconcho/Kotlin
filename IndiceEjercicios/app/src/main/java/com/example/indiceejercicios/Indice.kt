package com.example.indiceejercicios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Indice(onNavigateTo: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp, 50.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Button(
            onClick = { onNavigateTo(Rutas.Bandera.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("1.1. Bandera")
        }

        Button(
            onClick = { onNavigateTo(Rutas.Html5.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("1.2. HTML5")
        }

        Button(
            onClick = { onNavigateTo(Rutas.Mondrian.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("1.3. Mondrian")
        }

        Button(
            onClick = { onNavigateTo(Rutas.Tarjeta.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("2.1. Tarjeta")
        }

        Button(
            onClick = { onNavigateTo(Rutas.Pantalla.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.1. Pantalla")
        }

        Button(
            onClick = { onNavigateTo(Rutas.Tarjeta2.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.2. Tarjeta2")
        }

        Button(
            onClick = { onNavigateTo(Rutas.CabeceraPerfil.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.3. Cabecera perfil")
        }

        Button(
            onClick = { onNavigateTo(Rutas.ConfirmaciónCompra.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.4. Confirmación compra")
        }

        Button(
            onClick = { onNavigateTo(Rutas.CabeceraProducto.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.5. Cabecera producto")
        }

        Button(
            onClick = { onNavigateTo(Rutas.SelectorAvatar.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.6. Selector avatar")
        }

        Button(
            onClick = { onNavigateTo(Rutas.PantallaInicio.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.7. Pantalla inicio")
        }

        Button(
            onClick = { onNavigateTo(Rutas.Calculadora.ruta) },
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("3.8. Calculadora")
        }
    }
}