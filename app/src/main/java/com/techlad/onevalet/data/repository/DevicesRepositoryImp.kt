package com.techlad.onevalet.data.repository

import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.domain.datasource.DevicesDataSource
import com.techlad.onevalet.domain.repository.DevicesRepository
import com.techlad.onevalet.utils.Resource
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by umair.khalid on 15,January,2022
 **/

class DevicesRepositoryImp @Inject constructor(private val dataSource: DevicesDataSource) :
    DevicesRepository {
    override suspend fun getDevices(): Flow<Resource<List<Device>>> {
        return flow {
            emit(Resource.loading())
            val result = dataSource.getDevices()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getDeviceById(id: String): Flow<Resource<Device>> {
        return flow {
            emit(Resource.loading())
            val result = dataSource.getDeviceById(id)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun searchDevice(text: String): Flow<Resource<List<Device>>> {
        return flow {
            emit(Resource.loading())
            val result = dataSource.searchDevice(text)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}