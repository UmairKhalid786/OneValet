package com.techlad.onevalet.presentation.navigation.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.techlad.onevalet.R
import com.techlad.onevalet.presentation.navigation.Screens

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Composable
fun BackLayerMenu(
    modifier: Modifier, navigationHandler: (String?) -> Unit
) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(start = 50.dp, end = 50.dp), contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuItem(LocalContext.current.getString(R.string.devices)) {
                navigationHandler(Screens.Devices.title)
            }
            Divider()
            MenuItem(LocalContext.current.getString(R.string.settings)) {
                navigationHandler(Screens.Settings.title)
            }
            Divider()
            MenuItem(LocalContext.current.getString(R.string.about)) {
                navigationHandler(Screens.About.title)
            }
        }
    }
}

