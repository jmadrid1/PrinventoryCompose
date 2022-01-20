package com.example.prinventorycompose.features.common.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.prinventorycompose.ui.Magenta
import com.example.prinventorycompose.features.destinations.DirectionDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ToolBar(@StringRes text: Int,
            navigator: DestinationsNavigator,
            destination: DirectionDestination
){
    TopAppBar(
        title = { Text(
            text = stringResource(text),
            color = Color.White)
        },
        backgroundColor = Magenta,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                IconButton(
                    onClick = { navigator.navigate(destination) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        tint = Color.White,
                        contentDescription = ""
                    )
                }
            }
        },
    )
}