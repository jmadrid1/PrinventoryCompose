package com.example.prinventorycompose.features.toners.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TonerCountCard(circleColor: Color,
                   tonerAmount: Int){

    Card(elevation = 10.dp) {
        Column(modifier = Modifier
            .height(110.dp)
            .width(70.dp)
            .wrapContentHeight(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(modifier = Modifier
                .height(110.dp)
                .width(70.dp)
                .background(Color.White)
            ){
                Box(modifier = Modifier.padding(15.dp)
                    .size(35.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        circleColor,
                        shape = CircleShape
                    )
                )

                Text(modifier = Modifier.padding(bottom = 10.dp)
                    .align(Alignment.BottomCenter),
                    text = tonerAmount.toString(),
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}