package com.techlad.onevalet.di

import com.techlad.onevalet.domain.repository.DevicesRepository
import com.techlad.onevalet.domain.usecases.DevicesUseCase
import com.techlad.onevalet.domain.usecases.GetDeviceById
import com.techlad.onevalet.domain.usecases.GetDevices
import com.techlad.onevalet.domain.usecases.SearchDevices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by umair.khalid on 23,January,2022
 **/

@Module
@InstallIn(SingletonComponent::class)
class TestUseCasesModule {

    @Provides
    fun provideDevicesUseCase(repository: DevicesRepository) = DevicesUseCase(
        getDevices = GetDevices(repository),
        getDeviceById = GetDeviceById(repository),
        searchDevices = SearchDevices(repository)
    )
}