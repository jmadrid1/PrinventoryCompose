package com.example.prinventorycompose.features.printers.presentation.create_edit

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.common.TextFieldState
import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.example.prinventorycompose.features.navigation.Screen
import com.example.prinventorycompose.ui.Magenta
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@ExperimentalAnimationApi
@OptIn(ExperimentalFoundationApi::class)
@Destination(navGraph = "root")
@Composable
fun EditPrinterScreen(printer: Printer,
                      navigator: DestinationsNavigator,
                      viewModel: CreateEditPrinterViewModel = hiltViewModel()
) {
    val makeState = viewModel.make.value
    val modelState = viewModel.model.value
    val serialState = viewModel.serial.value
    val ownerState = viewModel.owner.value
    val deptState = viewModel.dept.value
    val locationState = viewModel.location.value
    val floorState = viewModel.floor.value
    val ipState = viewModel.ip.value

    LaunchedEffect(Unit){
        viewModel.populateFields(printer)
    }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is CreateEditPrinterViewModel.UiEvent.CreatePrinter -> {
                    navigator.popBackStack()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Magenta)
            .padding(top = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        EditFormTextfields(
            makeState = makeState,
            modelState = modelState,
            serialState = serialState,
            ownerState = ownerState,
            deptState = deptState,
            locationState = locationState,
            floorState = floorState,
            ipState = ipState,
            viewModel = viewModel
        )

        Spacer(modifier = Modifier.height(35.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 30.dp)
                .clip(CircleShape),
            enabled = true,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            onClick = {
                viewModel.onEvent(CreateEditPrinterEvent.CreatePrinter)
                navigator.navigate(Screen.PrinterScreen.route) {
                    popUpTo(Screen.PrinterDetailsScreen.route) {
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

@Composable
fun EditFormTextfields(makeState: TextFieldState,
                       modelState: TextFieldState,
                       serialState: TextFieldState,
                       ownerState: TextFieldState,
                       deptState: TextFieldState,
                       locationState: TextFieldState,
                       floorState: TextFieldState,
                       ipState: TextFieldState,
                       viewModel: CreateEditPrinterViewModel){
    Column(modifier = Modifier
        .wrapContentHeight(CenterVertically)
        .fillMaxWidth()
        .padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

        val localFocusManager = LocalFocusManager.current

        TextField(value = makeState.text,
            onValueChange = { if(it.length <= 8) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredMake(it)) },
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
            onValueChange = { if(it.length <= 16) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredModel(it)) },
            label = { Text("Model") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = serialState.text,
            onValueChange = { if(it.length <= 16) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredSerial(it)) },
            label = { Text("Serial") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = ownerState.text,
            onValueChange = { if(it.length <= 8) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredOwner(it)) },
            label = { Text("Owner") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = deptState.text,
            onValueChange = { if(it.length <= 12) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredDept(it)) },
            label = { Text("Dept") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = locationState.text,
            onValueChange = { if(it.length <= 10) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredLocation(it)) },
            label = { Text("Location") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = floorState.text,
            onValueChange = { if(it.length <= 8) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredFloor(it)) },
            label = { Text("Floor") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { localFocusManager.moveFocus(FocusDirection.Down) }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = ipState.text,
            onValueChange = { if(it.length <= 3) viewModel.onEvent(CreateEditPrinterEvent.OnEnteredIP(it)) },
            label = { Text("IP") },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(
                onDone = { localFocusManager.clearFocus(true) }
            )
        )
    }
}
