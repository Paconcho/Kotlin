package com.pmdm.kt2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@Composable
fun Alineaciones() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),

        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(Color.LightGray)
                .padding(16.dp)

        ){
            Row(
                modifier = Modifier.align(Alignment.TopEnd),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ){}

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ){}
            }

            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                horizontalArrangement = Arrangement.spacedBy(15.dp)

            ){
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                )

                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .height(50.dp),
                ){
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .background(Color.Gray)
                            .width(130.dp)
                            .height(25.dp)

                    ){}

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .background(Color.Gray)
                            .width(200.dp)
                            .height(20.dp)

                    ){}


                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Blue)
                    .padding(vertical = 8.dp, horizontal = 8.dp),

                contentAlignment = Alignment.Center
            ) {
                Text(text = "Status chip")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardLayoutScreenPreview() {
    Alineaciones()
}