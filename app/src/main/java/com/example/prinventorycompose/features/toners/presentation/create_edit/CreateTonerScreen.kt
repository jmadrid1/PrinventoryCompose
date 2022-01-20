package com.example.prinventorycompose.features.toners.presentation.create_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import com.example.prinventorycompose.ui.Cyan
import com.example.prinventorycompose.features.toners.presentation.create_edit.components.TonerSelectorsBody
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@Destination(navGraph = "toners")
@Composable
fun CreateTonerScreen(
    navigator: DestinationsNavigator,
    viewModel: CreateEditTonerViewModel = hiltViewModel()
) {
    val makeState = viewModel.make.value
    val modelState = viewModel.model.value
    val tonerModelState = viewModel.tonerModel.value

    val numberCountValues = listOf(
        "0",
        "1",
        "2",
        "3",
        "4",
    )

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is CreateEditTonerViewModel.UiEvent.CreateToner -> {
                    navigator.popBackStack()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cyan)
            .padding(10.dp),
        horizontalAlignment = CenterHorizontally,
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

        TonerSelectorsBody(
            numberCountValues,
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
            onClick = { viewModel.onEvent(CreateEditTonerEvent.CreateToner) },
        ) {
            Text(
                text = stringResource(id = R.string.btn_save),
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}







