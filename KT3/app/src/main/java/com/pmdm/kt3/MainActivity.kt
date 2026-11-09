package com.pmdm.kt3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun PantallaConfirmacionCompra() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(80.dp)
                .border(2.dp, Color.DarkGray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
                    Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Icono de la aplicación",
            modifier = Modifier.size(100.dp)
        )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "¡Pedido Confirmado!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Duvan ipsum dolor sit amet, consectetur adipiscing elit. Seddio euemod veltinumgenem signa, corta sult una.",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Resumen del Pedido",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Product Name x pedido\n" +
                        "Product Name x pedido\n" +
                        "Product Name x pedido\n" +
                        "Product Name x pedido\n",

            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Acción Ver Detalles */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Ver Detalles", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = { }
        ) {
            Text(
                text = "Volver al Inicio",
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Patata() {
    PantallaConfirmacionCompra()
}