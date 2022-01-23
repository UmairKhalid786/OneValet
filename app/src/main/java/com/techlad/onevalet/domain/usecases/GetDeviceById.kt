package com.techlad.onevalet.domain.usecases

import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.domain.repository.DevicesRepository
import com.techlad.onevalet.exceptions.InvalidOperationException
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by umair.khalid on 15,January,2022
 **/

class GetDeviceById(private val repository: DevicesRepository) {
    @Throws(InvalidOperationException::class)
    suspend operator fun invoke(id: String): Flow<Resource<Device>> {
        if (id.isBlank()) {
            throw InvalidOperationException("Device ID can't be empty.")
        }
        return repository.getDeviceById(id)
    }
}