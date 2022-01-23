package com.techlad.onevalet.data.datasource

import com.techlad.onevalet.domain.datasource.DevicesDataSource
import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.utils.Resource

// We will fake data source to test our repository
// In real apps we dont test our actual repositories, in this case as our datasource is abstracted
// so we can fake to to achieve it easily :)

class FakeDevicesDataSourceUI : DevicesDataSource {

    var testForError = false

    private val devices = listOf(
        Device(
            id = "1",
            type = "Mobile",
            price = 2230,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "iPhone",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "2",
            type = "Mobile",
            price = 1200,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "Nokia 3310",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        Device(
            id = "3",
            type = "Mobile",
            price = 1230,
            currency = "USD",
            is_favorite = false,
            image_url = "",
            title = "Samsung A31",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
    )

    override fun getDevices(): Resource<List<Device>> {
        return if (testForError)
            Resource.error("Something went wrong")
        else
            Resource.success(devices)
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