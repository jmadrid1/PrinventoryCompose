package com.example.prinventorycompose.features.toners.presentation.create_edit.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prinventorycompose.features.toners.presentation.create_edit.CreateEditTonerViewModel
import com.example.prinventorycompose.features.toners.presentation.util.Black
import com.example.prinventorycompose.features.toners.presentation.util.Cyan
import com.example.prinventorycompose.features.toners.presentation.util.Magenta
import com.example.prinventorycompose.features.toners.presentation.util.Yellow

@Composable
fun TonerSelectorsBody(numberCountValues: List<String>,
                   viewModel: CreateEditTonerViewModel
){

    TonerSelector(
        numberCountValues,
        Black,
        viewModel
    )

    Spacer(modifier = Modifier.height(16.dp))

    TonerSelector(
        numberCountValues,
        Cyan,
        viewModel
    )

    Spacer(modifier = Modifier.height(16.dp))

    TonerSelector(
        numberCountValues,
        Yellow,
        viewModel
    )

    Spacer(modifier = Modifier.height(16.dp))

    TonerSelector(
        numberCountValues,
        Magenta,
        viewModel
    )
}