package com.techlad.onevalet.ui.devices.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.techlad.onevalet.R
import com.techlad.onevalet.data.Device
import com.techlad.onevalet.ui.navigation.DetailsParam
import com.techlad.onevalet.ui.navigation.Screens

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun DevicesScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(10, {
                it.toString()
            }, itemContent = {
                DeviceCard(device = Device(it,
                    "Device $it",
                    R.drawable.ic_phone,
                    "Description for Device$it, This is dummy text for item $it. Device$it is available in $it ${if (it <= 1) "Country." else "Countries."}")) {

                    navController.navigate(buildDetailsIntent(deviceId = it.toString()))
                }
            })
        }
    }
}

fun buildDetailsIntent(deviceId: String) =
    Screens.Details.title.replace("{${DetailsParam.DEVICE_ID}}",
        deviceId)