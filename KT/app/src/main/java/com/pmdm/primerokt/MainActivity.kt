package com.pmdm.primerokt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmdm.primerokt.ui.theme.PrimeroKTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeroKTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        etiquetaHML5()
                    }
                }
            }
        }
    }
}

//@Composable
//fun TargetaPerfil(){
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .clip(RoundedCornerShape(12.dp))
//            .background(Color.Red)
//            .padding(16.dp)
//    ){
//        Text(text = "Nombre del alumno")
//        Text(text = "Desarrollo de Aplicaiones Multiplataforma")
//    }
//}

//    @Composable
//    fun banderaEspaña(modifier: Modifier = Modifier){
//        Column(
//            modifier = Modifier.fillMaxWidth()){
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .weight(1f)
//                        .background(Color.Red)
//                )
//                Spacer(
//                  modifier = Modifier
//                      .fillMaxWidth()
//                      .weight(2f)
//                      .background(Color.Yellow)
//
//                )
//                Spacer(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .weight(1f)
//                        .background(Color.Red)
//                )
//            }
//    }

@Composable
fun etiquetaHML5(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 1. HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "<HEADER>")
        }

        // 2. NAV
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "<NAV>")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.7f)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.LightGray)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                Text(text = "<SECTION>")


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "<ARTICLE>")
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "<ARTICLE>")
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "<ARTICLE>")
                }
            }

            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.LightGray)
                    .padding(12.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(text = "<ASIDE>")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "<FOOTER>")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeroKTTheme {
        etiquetaHML5()
    }
}