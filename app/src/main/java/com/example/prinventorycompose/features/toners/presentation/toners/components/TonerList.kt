package com.example.prinventorycompose.features.toners.presentation.toners.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prinventorycompose.features.destinations.TonerDetailsScreenDestination
import com.example.prinventorycompose.features.toners.domain.model.Toner
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun TonerList(navigator: DestinationsNavigator,
              toners: List<Toner>){

    LazyColumn(modifier = Modifier.padding(top = 10.dp)
        .fillMaxSize()
        .padding(horizontal = 10.dp)
    ) {
        items(toners) { toner ->
            TonerCard(
                toner = toner,
                onItemClick = {
                    navigator.navigate(TonerDetailsScreenDestination(toner))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}