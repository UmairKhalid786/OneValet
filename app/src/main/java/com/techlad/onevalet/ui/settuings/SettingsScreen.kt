package com.techlad.onevalet.ui.settuings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Settings")
    }
}