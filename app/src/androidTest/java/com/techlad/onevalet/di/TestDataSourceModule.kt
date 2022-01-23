package com.techlad.onevalet.di

import com.techlad.onevalet.domain.datasource.DevicesDataSource
import com.techlad.onevalet.data.datasource.FakeDevicesDataSourceUI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Module
@InstallIn(SingletonComponent::class)
class TestDataSourceModule {

    @Provides
    fun provideDevicesDataSource(): DevicesDataSource = FakeDevicesDataSourceUI()
}