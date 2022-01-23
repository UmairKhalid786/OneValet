package com.techlad.onevalet.presentation.devices.device_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.techlad.onevalet.presentation.devices.DevicesViewModel
import com.techlad.onevalet.presentation.devices.devices.TryAgainWidget
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.delay

/**
 * Created by umair.khalid on 15,January,2022
 **/

@Composable
fun DeviceDetails(
    modifier: Modifier = Modifier,
    deviceId: String?,
    viewModel: DevicesViewModel = hiltViewModel(),
) {

    val devicesResponse = viewModel.deviceDetail.collectAsState()

    LaunchedEffect(key1 = deviceId) {
        // Added delay for given little progress ;)
        delay(1000)
        deviceId?.let { viewModel.getDeviceDetailById(it) }
    }

    Box(modifier = modifier.fillMaxSize()) {
        when (devicesResponse.value.status) {
            Resource.Status.LOADING -> {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            Resource.Status.SUCCESS -> {
                devicesResponse.value.data?.let {
                    DeviceDetailContent(it)
                }
            }
            Resource.Status.ERROR -> {
                TryAgainWidget(devicesResponse.value.message) {
                    deviceId?.let { viewModel.getDeviceDetailById(it) }
                }
            }
        }
    }
}
