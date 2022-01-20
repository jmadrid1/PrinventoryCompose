package com.example.prinventorycompose.features.toners.presentation.create_edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prinventorycompose.features.common.TextFieldState
import com.example.prinventorycompose.features.toners.presentation.create_edit.CreateEditTonerEvent
import com.example.prinventorycompose.features.toners.presentation.create_edit.CreateEditTonerViewModel
import com.example.prinventorycompose.features.toners.presentation.util.Black
import com.example.prinventorycompose.features.toners.presentation.util.Cyan
import com.example.prinventorycompose.features.toners.presentation.util.Magenta
import com.example.prinventorycompose.features.toners.presentation.util.Yellow

@Composable
fun TonerSelector(numberCount: List<String>,
                  color: String,
                  viewModel: CreateEditTonerViewModel) {

    Row(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = color+ ":",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White,
        )

        var countValue: String by remember { mutableStateOf(numberCount[0]) }
        var expanded by remember { mutableStateOf(false) }

        Box {
            Row(Modifier
                .padding(start = 10.dp)
                .clickable {
                    expanded = !expanded
                }
                .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = countValue,
                    color = Color.Black,
                    fontSize = 18.sp)

                Icon(imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "")

                DropdownMenu(expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    numberCount.forEach{ count ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                countValue = count
                                when(color){
                                    Black ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredBlack(countValue))
                                    }
                                    Cyan ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredCyan(countValue))
                                    }

                                    Yellow ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredYellow(countValue))
                                    }
                                    Magenta ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredMagenta(countValue))
                                    }
                                }
                            },
                        modifier = Modifier.background(Color.White))
                        {
                            Text(text = countValue,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TonerSelector(numberCount: List<String>,
                  spinnerState: TextFieldState,
                  color: String,
                  viewModel: CreateEditTonerViewModel
) {
    Row(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = color+ ":",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.White,
        )

        var countValue: String by remember { mutableStateOf(numberCount[0]) }
        var expanded by remember { mutableStateOf(false) }

        Box(
            Modifier.wrapContentWidth(CenterHorizontally),
            contentAlignment = Alignment.Center) {
            Row(Modifier.padding(start = 5.dp)
                .clickable {
                    expanded = !expanded
                }
                .padding(2.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = spinnerState.text,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 8.dp))

                countValue = spinnerState.text

                Icon(imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "")

                DropdownMenu(expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    numberCount.forEach{ count ->
                        DropdownMenuItem(
                            onClick = {
                                expanded = false
                                countValue = count
                                when(color){
                                    Black ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredBlack(countValue))
                                    }
                                    Cyan ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredCyan(countValue))
                                    }

                                    Yellow ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredYellow(countValue))
                                    }
                                    Magenta ->{
                                        viewModel.onEvent(CreateEditTonerEvent.OnEnteredMagenta(countValue))
                                    }
                                }
                            },
                            modifier = Modifier.background(Color.White)
                        ) {
                            Text(text = countValue,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}