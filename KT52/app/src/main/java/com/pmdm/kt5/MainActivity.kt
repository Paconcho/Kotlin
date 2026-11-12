//package com.pmdm.kt5
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Calculadora()
//        }
//    }
//}
//@Composable
//fun Calculadora() {
//
//    var displayText by remember { mutableStateOf("0") }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier
//                .width(300.dp)
//                .background(Color.Yellow, shape = RoundedCornerShape(24.dp))
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Panel solar decorativo arriba a la derecha
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//                Box(
//                    modifier = Modifier
//                        .width(90.dp)
//                        .height(30.dp)
//                        .background(Color(0xFF7F6000), shape = RoundedCornerShape(4.dp))
//                )
//            }
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            // Pantalla de la calculadora
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp)
//                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
//                    .padding(horizontal = 16.dp),
//                contentAlignment = Alignment.CenterEnd
//            ) {
//
//                Text(
//                    text = displayText,
//                    fontSize = 32.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Blue
//                )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // Fila 1
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "7"
//                    }else{
//                        displayText += 7
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("7", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "8"
//                    }else{
//                        displayText += 8
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("8", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "9"
//                    }else{
//                        displayText += 9
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("9", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "%"
//                    }else{
//                        displayText += "%"
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("÷", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Fila 2
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "4"
//                    }else{
//                        displayText += 4
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("4", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "5"
//                    }else{
//                        displayText += 5
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("5", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {                    if (displayText == "0"){
//                    displayText = "6"
//                }else{
//                    displayText += 6
//                }}, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("6", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {                    if (displayText == "0"){
//                    displayText = "x"
//                }else{
//                    displayText += "x"
//                }}, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("x", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Fila 3
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "1"
//                    }else{
//                        displayText += 1
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("1", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                if (displayText == "0"){
//                    displayText = "2"
//                }else{
//                    displayText += 2
//                }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("2", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                if (displayText == "0"){
//                    displayText = "3"
//                }else{
//                    displayText += 3
//                }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("3", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                if (displayText == "0"){
//                    displayText = "-"
//                }else{
//                    displayText += "-"
//                }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("-", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Fila 4
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//                Button(onClick = {
//                if (displayText == "0"){
//                    displayText = "0"
//                }else{
//                    displayText += 0
//                }}, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("0", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "."
//                    }else{
//                        displayText += "."
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text(".", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "="
//                    }else{
//                        displayText += "="
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("=", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//                Button(onClick = {
//                    if (displayText == "0"){
//                        displayText = "+"
//                    }else{
//                        displayText += "+"
//                    }
//                }, modifier = Modifier.size(60.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red), contentPadding = PaddingValues(0.dp)) { Text("+", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
//            }
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Calculadora()
//}


//CON ASPECT RATIO

package com.pmdm.kt5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculadora()
        }
    }
}

@Composable
fun Calculadora() {
    var displayText by remember { mutableStateOf("0") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(320.dp) // Ligeramente ampliado para acomodar los espacios entre botones
                .background(Color.Yellow, shape = RoundedCornerShape(24.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Panel solar decorativo arriba a la derecha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(90.dp)
                        .height(30.dp)
                        .background(Color(0xFF7F6000), shape = RoundedCornerShape(4.dp))
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Pantalla de la calculadora
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = displayText,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fila 1 (7, 8, 9, ÷)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Button(
                    onClick = { displayText = if (displayText == "0") "7" else displayText + 7 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("7", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "8" else displayText + 8 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("8", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "9" else displayText + 9 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("9", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "%" else displayText + "%" },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("÷", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Fila 2 (4, 5, 6, x)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Button(
                    onClick = { displayText = if (displayText == "0") "4" else displayText + 4 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("4", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "5" else displayText + 5 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("5", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "6" else displayText + 6 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("6", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "x" else displayText + "x" },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("x", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Fila 3 (1, 2, 3, -)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Button(
                    onClick = { displayText = if (displayText == "0") "1" else displayText + 1 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("1", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "2" else displayText + 2 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("2", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "3" else displayText + 3 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("3", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "-" else displayText + "-" },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("-", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Fila 4 (0, ., =, +)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Button(
                    onClick = { displayText = if (displayText == "0") "0" else displayText + 0 },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("0", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "." else displayText + "." },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text(".", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "=" else displayText + "=" },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("=", fontSize = 22.sp, fontWeight = FontWeight.Bold) }

                Button(
                    onClick = { displayText = if (displayText == "0") "+" else displayText + "+" },
                    modifier = Modifier.weight(1f).aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Red),
                    contentPadding = PaddingValues(0.dp)
                ) { Text("+", fontSize = 22.sp, fontWeight = FontWeight.Bold) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora()
}