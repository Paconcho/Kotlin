package com.example.indiceejercicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CabeceraPerfil(onNavigateTo: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("3.3. Cabecera perfil") },
                navigationIcon = {
                    IconButton(onClick = {onNavigateTo(Rutas.Indice.ruta)}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver atrás"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(0.dp, 40.dp)
                .background(Color.LightGray)
                .border(
                    color=Color.Gray,
                    width = 1.dp
                )
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.cabecera),
                contentDescription = "Avatar"
            )
            Column() {
                Text(
                    text = "Daniel Rebollo",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Profesor de informática",
                    fontSize = 14.sp
                )
                Text(
                    text = "CIFP A Carballeira",
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)

                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorito",
                        tint = Color.DarkGray,
                        modifier = Modifier.clickable(onClick = {})
                    )
                    Icon(
                        imageVector = Icons.Default.AddAPhoto,
                        contentDescription = "Foto",
                        tint = Color.DarkGray,
                        modifier = Modifier.clickable(onClick = {})
                    )
                }
            }
        }
    }
}