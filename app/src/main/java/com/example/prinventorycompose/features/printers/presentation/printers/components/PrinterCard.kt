package com.example.prinventorycompose.features.printers.presentation.printers.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prinventorycompose.R
import com.example.prinventorycompose.features.printers.domain.model.Printer
import com.example.prinventorycompose.ui.Magenta

@ExperimentalMaterialApi
@Composable
fun PrinterCard(printer: Printer,
                 onItemClick:() -> Unit) {

    Card(onClick = onItemClick,
        modifier = Modifier.fillMaxWidth()
            .height(110.dp)
            .padding(2.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 10.dp
    ) {
        Row(modifier = Modifier.fillMaxSize()
            .background(Color.White)
        ) {

            Image(
                contentDescription = "",
                painter = painterResource(id = R.drawable.ic_printer),
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxHeight()
                    .width(100.dp)
                    .background(Magenta)
                    .align(CenterVertically)
                    .padding(horizontal = 15.dp)
            )

            PrinterCardDetails(
                Modifier.padding(
                    start = 10.dp,
                )
                , printer
            )
        }
    }
}

@Composable
fun PrinterCardDetails(
    modifier: Modifier,
    printer: Printer
) {
    Column(modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = printer.make + " " + printer.model,
            fontSize = 25.sp,
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(
                    top = 4.dp,
                    start = 15.dp
                )
        )

        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            ) {
                append(stringResource(id = R.string.list_row_printer_dept) + "  " + printer.dept.toString())
            }
        },
            modifier.padding(
                top = 3.dp,
                start = 15.dp
            )
        )

        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            ) {
                append(stringResource(id = R.string.list_row_printer_ip) + "  " + printer.ip.toString())
            }
        },
            modifier.padding(
                top = 0.dp,
                start = 15.dp
            )
        )
    }
}