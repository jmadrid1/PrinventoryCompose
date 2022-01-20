package com.example.prinventorycompose.features.printers.presentation.details

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.common.components.DetailsBanner
import com.example.prinventorycompose.features.destinations.EditPrinterScreenDestination
import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.example.prinventorycompose.features.printers.presentation.create_edit.CreateEditPrinterEvent
import com.example.prinventorycompose.features.printers.presentation.create_edit.CreateEditPrinterViewModel
import com.example.prinventorycompose.features.printers.presentation.details.component.PrinterDetailsContent
import com.example.prinventorycompose.ui.Magenta
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.flow.collectLatest

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Destination(navGraph = "root")
@Composable
fun PrinterDetailsScreen(printer: Printer,
                         navigator: DestinationsNavigator,
                         viewModel: CreateEditPrinterViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is CreateEditPrinterViewModel.UiEvent.DeletePrinter -> {
                    navigator.popBackStack()
                }
            }
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = CenterHorizontally)
    {
        DetailsToolbar(
            navigator,
            viewModel,
            printer
        )

        DetailsBanner(
            R.drawable.ic_printer,
            Magenta,
            Magenta
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = printer.make + " " + printer.model,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier
                .align(CenterHorizontally)
                .wrapContentWidth(CenterHorizontally)
                .wrapContentHeight(CenterVertically)
        )

        Spacer(modifier = Modifier.height(15.dp))

        PrinterDetailsContent(printer = printer)

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 10.dp)
                .clip(CircleShape),
            enabled = true,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            onClick = {
                navigator.navigate(
                    EditPrinterScreenDestination(
                    printer)
                )
            },
        ) {
            Text(
                text = stringResource(id = R.string.btn_edit_printer),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DetailsToolbar(navigator: DestinationsNavigator,
                   viewModel: CreateEditPrinterViewModel = hiltViewModel(),
                   printer: Printer){
    TopAppBar(
        title = { } ,
        backgroundColor = Magenta,
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
                    onClick = { viewModel.onEvent(CreateEditPrinterEvent.DeletePrinter(printer)) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = Color.White,
                        contentDescription = "Delete Printer"
                    )
                }
            }
        },
        modifier = Modifier
            .background(Magenta)
            .height(60.dp)
            .fillMaxWidth()
    )
}



@Preview(showBackground = true)
@Composable
fun PreviewDetailsBanner(){

}
