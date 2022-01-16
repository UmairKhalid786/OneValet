package com.techlad.onevalet.ui.devices.device_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Created by umair.khalid on 15,January,2022
 **/

@Composable
fun DeviceDetails(
    modifier: Modifier = Modifier,
    deviceId: String?) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        deviceId?.let {
            Text(text = it)
        }
    }
}
