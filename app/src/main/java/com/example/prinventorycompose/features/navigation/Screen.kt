package com.example.prinventorycompose.features.navigation

sealed class Screen(val route: String) {
    object PrinterScreen: Screen("printer_screen")
    object PrinterDetailsScreen: Screen("printer_details_screen/{printer}")

    object TonerScreen: Screen("toner_screen")
    object TonerDetailsScreen: Screen("toner_details_screen/{toner}")
}