package com.techlad.onevalet.domain.repository

import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by umair.khalid on 15,January,2022
 **/

interface DevicesRepository {
    suspend fun getDevices(): Flow<Resource<List<Device>>>
    suspend fun getDeviceById(id: String): Flow<Resource<Device>>
    suspend fun searchDevice(text: String): Flow<Resource<List<Device>>>
}