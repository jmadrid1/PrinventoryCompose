package com.example.prinventorycompose.features.toners.presentation.toners

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
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.common.components.BottomTab
import com.example.prinventorycompose.features.common.components.EmptyList
import com.example.prinventorycompose.features.common.components.ToolBar
import com.example.prinventorycompose.features.navigation.BottomNavigationScreens
import com.example.prinventorycompose.features.destinations.CreateTonerScreenDestination
import com.example.prinventorycompose.features.printers.presentation.printers.PrinterActivity
import com.example.prinventorycompose.features.toners.presentation.toners.components.TonerList
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Destination(start = true, navGraph = "toners")
@Composable
fun TonerScreen(navigator: DestinationsNavigator,
                viewModel: TonerViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    val context = LocalContext.current

    val items = listOf(
        BottomNavigationScreens.PrinterScreen,
        BottomNavigationScreens.TonerScreen
    )

    Scaffold(
        topBar = {
            ToolBar(
                R.string.title_activity_toner,
                navigator,
                CreateTonerScreenDestination
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
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding())
                .fillMaxSize()
                .background(Color.White)
        ) {
            if(state.toners.isEmpty()){
                EmptyList(R.string.list_toner_empty)
            }else{
                TonerList(
                    navigator,
                    toners = state.toners
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
        contentColor = Color.Black
    ) {
        val currentRoute = items[1]
        items.forEach { item ->
            BottomTab(item,
                currentRoute.toString(),
                onTabClick = {
                when(item){
                    is BottomNavigationScreens.PrinterScreen -> {
                        val intent = Intent(context, PrinterActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        context.startActivity(intent)
                    }
                    is BottomNavigationScreens.TonerScreen -> { }
                }
            })
        }
    }
}
