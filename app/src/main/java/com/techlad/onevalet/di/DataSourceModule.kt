package com.techlad.onevalet.di

import com.techlad.onevalet.domain.datasource.DevicesDataSource
import com.techlad.onevalet.data.datasource.DevicesDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun provideDevicesDataSource(): DevicesDataSource = DevicesDataSourceImpl()
}