package com.techlad.onevalet.domain.usecases

import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.domain.repository.DevicesRepository
import com.techlad.onevalet.exceptions.InvalidOperationException
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by umair.khalid on 15,January,2022
 **/

class SearchDevices(private val repository: DevicesRepository) {
    @Throws(InvalidOperationException::class)
    suspend operator fun invoke(content: String): Flow<Resource<List<Device>>> {
        if (content.isBlank()) {
            throw InvalidOperationException("The search text can't be empty.")
        }
        return repository.searchDevice(content)
    }
}
