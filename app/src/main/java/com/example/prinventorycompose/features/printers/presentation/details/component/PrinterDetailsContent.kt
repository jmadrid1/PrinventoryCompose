package com.example.prinventorycompose.features.printers.presentation.details.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.printers.domain.model.Printer

@Composable
fun PrinterDetailsContent(printer: Printer){
    Column(modifier = Modifier
        .wrapContentHeight(Alignment.CenterVertically)
        .wrapContentWidth(Alignment.CenterHorizontally),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.printer_details_serial))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                ) {
                    append(printer.serial.toString())
                }
            },
            Modifier.padding(
                top = 0.dp,
                start = 25.dp
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.printer_details_owner))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                ) {
                    append(printer.owner.toString())
                }
            },
            Modifier.padding(
                top = 0.dp,
                start = 25.dp
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.printer_details_dept))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                ) {
                    append(printer.dept.toString())
                }
            },
            Modifier.padding(
                top = 0.dp,
                start = 25.dp
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.printer_details_location))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                ) {
                    append(printer.location.toString())
                }
            },
            Modifier.padding(
                top = 0.dp,
                start = 25.dp
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.printer_details_floor))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                ) {
                    append(printer.floor.toString())
                }
            },
            Modifier.padding(
                top = 0.dp,
                start = 25.dp
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                ) {
                    append(stringResource(id = R.string.printer_details_ip))
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                ) {
                    append(printer.ip.toString())
                }
            },
            Modifier.padding(
                top = 0.dp,
                start = 25.dp
            )
        )
    }
}