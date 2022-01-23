package com.techlad.onevalet.domain.usecases

import com.techlad.onevalet.domain.repository.DevicesRepository

/**
 * Created by umair.khalid on 23,January,2022
 **/

class GetDevices(private val repository: DevicesRepository) {
    suspend operator fun invoke() = repository.getDevices()
}