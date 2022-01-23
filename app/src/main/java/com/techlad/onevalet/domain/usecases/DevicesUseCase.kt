package com.techlad.onevalet.domain.usecases

/**
 * Created by umair.khalid on 15,January,2022
 **/

data class DevicesUseCase(
    val getDevices: GetDevices,
    val getDeviceById: GetDeviceById,
    val searchDevices: SearchDevices
)