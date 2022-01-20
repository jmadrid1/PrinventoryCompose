package com.example.prinventorycompose.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.prinventorycompose.R

sealed class BottomNavigationScreens(
    @StringRes val route: Int,
    @StringRes val resourceId: Int,
    @DrawableRes val drawableRes: Int
) {

    object PrinterScreen : BottomNavigationScreens(
        R.string.bottom_nav_route_printer,
        R.string.bottom_nav_tab_printer,
        R.drawable.dashboard_printer
    )

    object TonerScreen : BottomNavigationScreens(
        R.string.bottom_nav_route_toner,
        R.string.bottom_nav_tab_toner,
        R.drawable.dashboard_toner
    )

//    object TonerScreen : BottomNavigationScreens(
//        "toner_screen",
//        R.string.bottom_nav_tab_toner,
//        R.drawable.dashboard_toner
//    )

}