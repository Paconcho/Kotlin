package com.example.indiceejercicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
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
fun SelectorAvatar(onNavigateTo: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("3.6. Selector avatar") },
                navigationIcon = {
                    IconButton(onClick = { onNavigateTo(Rutas.Indice.ruta) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver atrás"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(10.dp, 40.dp)
                .border(
                    color = Color.DarkGray,
                    width = 1.dp
                )
                .padding(10.dp)
        ) {
            Text(
                text = "Historias",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(5.dp)
                    .horizontalScroll(scrollState),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona2),
                        contentDescription = "Persona 2",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Cyan)
                            .border(
                                color = Color.Blue,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "Pepe",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona1),
                        contentDescription = "Persona 1",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Cyan)
                            .border(
                                color = Color.Blue,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "Luis",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona6),
                        contentDescription = "Persona 6",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Magenta)
                            .border(
                                color = Color.Red,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "Ana",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona5),
                        contentDescription = "Persona 5",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Magenta)
                            .border(
                                color = Color.Red,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "Pilar",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona3),
                        contentDescription = "Persona 3",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Cyan)
                            .border(
                                color = Color.Blue,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "Juan",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona4),
                        contentDescription = "Persona 4",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Magenta)
                            .border(
                                color = Color.Red,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "María",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.persona7),
                        contentDescription = "Persona 7",
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .background(Color.Magenta)
                            .border(
                                color = Color.Red,
                                width = 2.dp,
                                shape = CircleShape
                            )
                            .padding(5.dp)
                    )
                    Text(
                        text = "Carmen",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}