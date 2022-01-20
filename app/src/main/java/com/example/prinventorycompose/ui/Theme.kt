package com.example.prinventorycompose.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White

private val AppColors = lightColors(
    primary = Magenta,
    background = Background,
    surface = White,
    onSurface = White
)

@Composable
fun PrinventoryComposeTheme(darkTheme: Boolean = true,
                            content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = AppColors,
        content = content
    )
}