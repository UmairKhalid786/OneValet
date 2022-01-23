package com.techlad.onevalet.presentation.devices.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.techlad.onevalet.presentation.devices.DevicesViewModel
import com.techlad.onevalet.presentation.navigation.DetailsParam
import com.techlad.onevalet.presentation.navigation.Screens
import com.techlad.onevalet.utils.Resource.Status.ERROR
import com.techlad.onevalet.utils.Resource.Status.LOADING
import com.techlad.onevalet.utils.Resource.Status.SUCCESS
import kotlinx.coroutines.delay

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun DevicesScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: DevicesViewModel = hiltViewModel(),
) {
    val devicesResponse = viewModel.devicesList.collectAsState()

    LaunchedEffect(key1 = Unit) {
        // Added little delay to show progress ;)
//        delay(1000)
        viewModel.fetchAllDevices()
    }

    when (devicesResponse.value.status) {
        LOADING -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        SUCCESS -> {
            devicesResponse.value.data?.let {
                DevicesList(list = it, onTextChange = {
                    viewModel.searchDevice(it)
                }) {
                    navController.navigate(buildDetailsIntent(it.id))
                }
            }
        }
        ERROR -> {
            TryAgainWidget(devicesResponse.value.message) {
                viewModel.fetchAllDevices()
            }
        }
    }
}

fun buildDetailsIntent(deviceId: String) =
    Screens.Details.title.replace("{${DetailsParam.DEVICE_ID}}",
        deviceId)