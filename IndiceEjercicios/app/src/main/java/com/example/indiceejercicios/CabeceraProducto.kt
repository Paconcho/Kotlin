package com.example.indiceejercicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CabeceraProducto(onNavigateTo: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("3.5. Cabecera producto") },
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(15.dp, 40.dp)
                .height(240.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    color=Color.DarkGray,
                    width = 1.dp,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(Color.LightGray)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.zapatillas),
                    contentDescription = "Zapatillas chulas",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .weight(3f)
                        .clip(RoundedCornerShape(10.dp, 10.dp))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(
                        text = "Zapatillas Hacendado Air 7",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.TopStart)
                    )
                    Text(
                        text = "9,95€",
                        modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.BottomStart)
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorito",
                tint = Color.Red,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 10.dp, 40.dp)
                    .size(40.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}