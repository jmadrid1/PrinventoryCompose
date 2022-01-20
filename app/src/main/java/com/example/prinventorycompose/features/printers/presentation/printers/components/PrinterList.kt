package com.example.prinventorycompose.features.printers.presentation.printers.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prinventorycompose.features.destinations.PrinterDetailsScreenDestination
import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun PrinterList(navigator: DestinationsNavigator,
                printers: List<Printer>){

    LazyColumn(modifier = Modifier.padding(top = 10.dp)
        .fillMaxSize()
        .padding(horizontal = 10.dp)
    ) {
        items(printers) { printer ->
            PrinterCard(
                printer = printer,
                onItemClick = { navigator.navigate(PrinterDetailsScreenDestination(printer)) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}