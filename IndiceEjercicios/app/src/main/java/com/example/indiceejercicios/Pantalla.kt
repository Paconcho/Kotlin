package com.example.indiceejercicios

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla(onNavigateTo: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("3.1. Pantalla") },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .border(
                    color = Color.Black,
                    width = 1.dp
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .background(Color.Green)
                    .padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .fillMaxHeight(0.6f)
                        .align(Alignment.TopCenter),
                    painter = painterResource(R.drawable.lal),
                    contentDescription = "Los Angeles Lakers"
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.BottomStart),
                    text = "ffds f dsa fjds f ds f dsaf dksañfjdsaf dsja fd sjak f",
                    textAlign = TextAlign.Left
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .background(Color.Yellow)
                    .padding(50.dp)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "ffds f dsa fjds f ds f dsaf f  dksañfjdsaffs f dsaf f dsaf dsa fjds f ds f dsaf " +
                            "dksañfjdsafff dsaf s f dsaf f dsaf dsa fjds f ds f dsaf d" +
                            "ksañfjdsaffdksañfjdsaff dsa fjds f ds f dsaf dksañfjdsaff dsa fjds f ds f dsaf " +
                            "dksañfjdsaff dsa fjds f ds f dsaf dksañfjdsaff dsa fjds f ds f dsaf dksañfjdsaff dsa fjds f ds f dsaf " +
                            "dksañfjdsaf fjds f ds f dsaf dksañfjdsafdksañfjdsaf dsja fd sjak f",
                    textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Magenta)
                    .padding(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(25.dp)
                        .background(Color.Black)
                        .align(Alignment.CenterStart)
                )
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(25.dp)
                        .background(Color.Black)
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }
}