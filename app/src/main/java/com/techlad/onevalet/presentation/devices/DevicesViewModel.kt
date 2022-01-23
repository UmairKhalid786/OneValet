package com.techlad.onevalet.presentation.devices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.domain.usecases.DevicesUseCase
import com.techlad.onevalet.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by umair.khalid on 16,January,2022
 **/

@HiltViewModel
class DevicesViewModel @Inject constructor(private val useCase: DevicesUseCase) : ViewModel() {

    private var searchJob: Job? = null

    private val _devicesList = MutableStateFlow<Resource<List<Device>>>(Resource.loading())
    val devicesList: StateFlow<Resource<List<Device>>> = _devicesList

    private val _deviceDetail = MutableStateFlow<Resource<Device>>(Resource.loading())
    val deviceDetail: StateFlow<Resource<Device>> = _deviceDetail

    fun fetchAllDevices() {
        viewModelScope.launch {
            useCase.getDevices().collect {
                _devicesList.value = it
            }
        }
    }

    fun getDeviceDetailById(id: String) {
        viewModelScope.launch {
            useCase.getDeviceById(id).collect {
                _deviceDetail.value = it
            }
        }
    }

    fun searchDevice(text: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            // To make search cancelable
            delay(300)
            if (text.isBlank()) {
                fetchAllDevices()
                return@launch
            }
            useCase.searchDevices(text).collect {
                _devicesList.value = it
            }
        }
    }
}