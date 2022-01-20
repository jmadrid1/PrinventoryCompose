package com.example.prinventorycompose.features.common.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.prinventorycompose.features.navigation.BottomNavigationScreens

@Composable
fun RowScope.BottomTab(
    screen: BottomNavigationScreens,
    currentRoute: String?,
    onTabClick:() -> Unit
) {

    BottomNavigationItem(
        icon = { Icon(
            painterResource(screen.drawableRes),
            stringResource(id = screen.resourceId)
        )
        },
        selected = currentRoute?.equals(screen.route) == true,
        selectedContentColor = Color.Magenta,
        unselectedContentColor = Color.White.copy(0.6f),
        alwaysShowLabel = true,
        onClick = onTabClick
    )
}