package com.techlad.onevalet.data.repository

import com.techlad.onevalet.data.datasource.FakeDevicesDataSource
import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.domain.repository.DevicesRepository
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FakeDevicesRepository(val dataSource: FakeDevicesDataSource) : DevicesRepository {

    override suspend fun getDevices(): Flow<Resource<List<Device>>> {
        return flow {
            emit(dataSource.getDevices())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getDeviceById(id: String): Flow<Resource<Device>> {
        return flow {
            emit(dataSource.getDeviceById(id))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun searchDevice(text: String): Flow<Resource<List<Device>>> {
        return flow {
            emit(dataSource.searchDevice(text))
        }.flowOn(Dispatchers.IO)
    }
}