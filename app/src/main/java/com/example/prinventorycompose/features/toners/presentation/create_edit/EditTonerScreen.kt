package com.example.prinventorycompose.features.toners.presentation.create_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.navigation.Screen
import com.example.prinventorycompose.features.toners.presentation.create_edit.components.TonerSelector
import com.example.prinventorycompose.features.toners.domain.model.Toner
import com.example.prinventorycompose.features.toners.presentation.util.Black
import com.example.prinventorycompose.features.toners.presentation.util.Cyan
import com.example.prinventorycompose.features.toners.presentation.util.Magenta
import com.example.prinventorycompose.features.toners.presentation.util.Yellow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@Destination(navGraph = "toners")
@Composable
fun EditTonerScreen(toner: Toner,
                    navigator: DestinationsNavigator,
                    viewModel: CreateEditTonerViewModel = hiltViewModel()
) {
    val makeState = viewModel.make.value
    val modelState = viewModel.model.value
    val tonerModelState = viewModel.tonerModel.value
    val blackState = viewModel.black.value
    val cyanState = viewModel.cyan.value
    val yellowState = viewModel.yellow.value
    val magentaState = viewModel.magenta.value

    val numberCount = listOf(
        "0",
        "1",
        "2",
        "3",
        "4",
    )

    LaunchedEffect(Unit){
        viewModel.populateFields(toner)
    }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is CreateEditTonerViewModel.UiEvent.CreateToner -> {
                    navigator.navigateUp()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6cc9e7))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        val localFocusManager = LocalFocusManager.current

        TextField(value = makeState.text,
            onValueChange = { if(it.length <= 8) viewModel.onEvent(CreateEditTonerEvent.OnEnteredMake(it)) },
            label = { Text("Make") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = modelState.text,
            onValueChange = { if(it.length <= 8) viewModel.onEvent(CreateEditTonerEvent.OnEnteredModel(it)) },
            label = { Text("Model") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = tonerModelState.text,
            onValueChange = { if(it.length <= 8) viewModel.onEvent(CreateEditTonerEvent.OnEnteredTonerModel(it)) },
            label = { Text("Toner Model") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(60.dp))

        TonerSelector(
            numberCount,
            blackState,
            Black,
            viewModel
        )

        Spacer(modifier = Modifier.height(16.dp))

        TonerSelector(
            numberCount,
            cyanState,
            Cyan,
            viewModel
        )

        Spacer(modifier = Modifier.height(16.dp))

        TonerSelector(
            numberCount,
            yellowState,
            Yellow,
            viewModel
        )

        Spacer(modifier = Modifier.height(16.dp))

        TonerSelector(
            numberCount,
            magentaState,
            Magenta,
            viewModel
        )

        Spacer(modifier = Modifier.height(65.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 30.dp)
                .clip(CircleShape),
            enabled = true,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = {
                viewModel.onEvent(CreateEditTonerEvent.CreateToner)
                navigator.navigate(Screen.TonerScreen.route) {
                    popUpTo(Screen.TonerDetailsScreen.route) {
                        inclusive = true
                    }
                }
            },
        ) {
            Text(
                text = stringResource(id = R.string.btn_update),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}



