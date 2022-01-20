package com.example.prinventorycompose.features.printers.presentation.printers

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.common.components.BottomTab
import com.example.prinventorycompose.features.common.components.EmptyList
import com.example.prinventorycompose.features.common.components.ToolBar
import com.example.prinventorycompose.features.navigation.BottomNavigationScreens
import com.example.prinventorycompose.features.destinations.CreatePrinterScreenDestination
import com.example.prinventorycompose.features.printers.presentation.printers.components.PrinterList
import com.example.prinventorycompose.features.toners.presentation.toners.TonerActivity
import com.example.prinventorycompose.ui.Background
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Destination(start = true, navGraph = "root")
@Composable
fun PrinterScreen(navigator: DestinationsNavigator,
                viewModel: PrinterViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    val context = LocalContext.current

    val items = listOf(
        BottomNavigationScreens.PrinterScreen,
        BottomNavigationScreens.TonerScreen
    )

    Scaffold(
        topBar = {
            ToolBar(
                R.string.title_activity_printer,
                navigator,
                CreatePrinterScreenDestination
            )
        },
        bottomBar = {
            BottomNavigation(
                items,
                context
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding())
                .fillMaxSize()
                .background(Background)
        ) {
            if(state.printers.isEmpty()){
                EmptyList(R.string.list_printer_empty)
            }else{
                PrinterList(
                    navigator,
                    printers = state.printers
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@SuppressLint("ResourceType")
@Composable
fun BottomNavigation(
    items: List<BottomNavigationScreens>,
    context: Context) {

    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.Black,
    ) {
        val currentRoute = items[0]
        items.forEach { item ->
            BottomTab(item, currentRoute.toString(),
                onTabClick = {
                    when(item){
                        is BottomNavigationScreens.PrinterScreen -> {}
                        is BottomNavigationScreens.TonerScreen -> {
                            val intent = Intent(context, TonerActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            context.startActivity(intent)
                        }
                    }
                }
            )
        }
    }
}



