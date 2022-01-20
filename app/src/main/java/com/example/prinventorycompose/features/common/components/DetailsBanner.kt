package com.example.prinventorycompose.features.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun DetailsBanner(@DrawableRes drawableRes: Int,
                  bannerBackgroundColor: Color,
                  colorFilter: Color
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(310.dp)
            .background(bannerBackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier
            .size(230.dp)
            .clip(CircleShape)
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                contentDescription = "",
                painter = painterResource(drawableRes),
                colorFilter = ColorFilter.tint(colorFilter),
                modifier = Modifier
                    .size(125.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

}