package com.techlad.onevalet.presentation.devices.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by umair.khalid on 17,January,2022
 **/

@Composable
fun TryAgainWidget(message: String?, onTryAgain: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(50.dp)) {
            Text(text = message ?: "Something went wrong")
            Button(onClick = onTryAgain) {
                Text(text = "Try again")
            }
        }
    }
}