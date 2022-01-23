package com.techlad.onevalet.data.datasource

import com.techlad.onevalet.domain.datasource.DevicesDataSource
import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.utils.Resource

class DevicesDataSourceImpl : DevicesDataSource {
    // Can be stored anywhere, network, local storage etc
    val devices = listOf(
        Device(
            id = "12345",
            type = "Mobile",
            price = 2230,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "iPhone",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "65438",
            type = "Mobile",
            price = 1200,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "Nokia 3310",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "8883",
            type = "Mobile",
            price = 1230,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "Samsung A31",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "23891",
            type = "Mobile",
            price = 2290,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "Samsung ABC",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "5317",
            type = "Mobile",
            price = 200,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "iPhone 6s",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "1238",
            type = "Mobile",
            price = 2000,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "iPhone X Max",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
    )

    override fun getDevices(): Resource<List<Device>> {
        return Resource.success(devices)
    }

    override fun getDeviceById(id: String): Resource<Device> {
        return devices.find { it.id == id }?.let { Resource.success(data = it) }
            ?: Resource.error("No record found with given ID $id")
    }

    override fun searchDevice(text: String): Resource<List<Device>> {
        return devices.filter {
            it.title.contains(text, true) || it.description.contains(text,
                true)
        }.let {
            if (it.isNotEmpty()) Resource.success(it) else Resource.error("No record found with given query $text")
        }
    }
}