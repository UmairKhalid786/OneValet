package com.techlad.onevalet.domain.datasource

import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.utils.Resource

/**
 * Created by umair.khalid on 15,January,2022
 **/

interface DevicesDataSource {
    fun getDevices(): Resource<List<Device>>
    fun getDeviceById(id: String): Resource<Device>
    fun searchDevice(text: String): Resource<List<Device>>
}