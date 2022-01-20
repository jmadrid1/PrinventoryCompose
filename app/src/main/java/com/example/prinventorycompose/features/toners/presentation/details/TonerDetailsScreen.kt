package com.example.prinventorycompose.features.toners.presentation.details

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prinventorycompose.R
import com.example.prinventorycompose.ui.Cyan
import com.example.prinventorycompose.features.common.components.DetailsBanner
import com.example.prinventorycompose.features.destinations.EditTonerScreenDestination
import com.example.prinventorycompose.features.toners.domain.model.Toner
import com.example.prinventorycompose.features.toners.presentation.create_edit.CreateEditTonerEvent
import com.example.prinventorycompose.features.toners.presentation.create_edit.CreateEditTonerViewModel
import com.example.prinventorycompose.features.toners.presentation.details.components.TonerCountContent
import com.example.prinventorycompose.ui.Magenta
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Destination(navGraph = "toners")
@Composable
fun TonerDetailsScreen(toner: Toner,
                       navigator: DestinationsNavigator,
                       viewModel: CreateEditTonerViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is CreateEditTonerViewModel.UiEvent.DeleteToner -> {
                    navigator.popBackStack()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            DetailsToolbar(
                navigator,
                viewModel,
                toner
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
                .fillMaxSize()
                .background(Color.White)
        ) {
            DetailsBanner(
                R.drawable.ic_toner,
                Cyan,
                Cyan
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(text = toner.make + " " + toner.model,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(25.dp))

            TonerCountContent(toner)

            Spacer(modifier = Modifier.height(65.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 10.dp)
                    .clip(CircleShape),
                enabled = true,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                onClick = { navigator.navigate(EditTonerScreenDestination(toner)) },
            ) {
                Text(
                    text = stringResource(id = R.string.btn_edit_toner),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}

@Composable
fun DetailsToolbar(navigator: DestinationsNavigator,
                   viewModel: CreateEditTonerViewModel = hiltViewModel(),
                   toner: Toner
){
    TopAppBar(
        title = { } ,
        backgroundColor = Cyan,
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                IconButton(
                    onClick = {  navigator.popBackStack()  }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        tint = Color.White,
                        contentDescription = "Close"
                    )
                }
                IconButton(
                    onClick = {
                        viewModel.onEvent(CreateEditTonerEvent.DeleteToner(toner))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = Color.White,
                        contentDescription = "Delete Toner"
                    )
                }
            }
        },
        modifier = Modifier.background(Magenta)
                .height(60.dp)
            .fillMaxWidth()
    )
}

