package com.example.prinventorycompose.features.toners.presentation.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.prinventorycompose.features.toners.domain.model.Toner

@Composable
fun TonerCountContent(toner: Toner){
    Row(
        Modifier.wrapContentHeight(Alignment.CenterVertically)
        .fillMaxWidth(),
        Arrangement.Center
    ) {
        TonerCountCard(
            Color.Black,
            toner.black!!
        )

        Spacer(modifier = Modifier.width(15.dp))

        TonerCountCard(
            Color.Cyan,
            toner.cyan!!
        )

        Spacer(modifier = Modifier.width(15.dp))

        TonerCountCard(
            Color.Yellow,
            toner.yellow!!
        )

        Spacer(modifier = Modifier.width(15.dp))

        TonerCountCard(
            Color.Magenta,
            toner.magenta!!
        )
    }
}