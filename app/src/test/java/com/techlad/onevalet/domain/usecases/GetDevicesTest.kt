package com.techlad.onevalet.domain.usecases

import com.google.common.truth.Truth.assertThat
import com.techlad.onevalet.data.datasource.FakeDevicesDataSource
import com.techlad.onevalet.data.repository.FakeDevicesRepository
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDevicesTest {
    private lateinit var getDevicesUseCase: GetDevices
    private lateinit var repository: FakeDevicesRepository
    private lateinit var fakeDataSourceFake: FakeDevicesDataSource

    @Before
    fun setUp() {
        fakeDataSourceFake = FakeDevicesDataSource()
        repository = FakeDevicesRepository(fakeDataSourceFake)
        getDevicesUseCase = GetDevices(repository)
    }

    @Test
    fun `Check if devices list is not empty`() = runBlocking {
        val devices = getDevicesUseCase().first().data
        assertThat(devices?.toList().isNullOrEmpty()).isFalse()
    }

    @Test
    fun `Check if status is successful`() = runBlocking {
        val status = getDevicesUseCase().first().status
        assertThat(status == Resource.Status.SUCCESS).isTrue()
    }

    @Test
    fun `Check if status is successful and data is not available`() = runBlocking {
        val response = getDevicesUseCase().first()

        assertThat(response.status == Resource.Status.SUCCESS && response.data.isNullOrEmpty()).isFalse()
    }

    @Test
    fun `Check if status is successful and data is available`() = runBlocking {
        val response = getDevicesUseCase().first()

        assertThat(response.status == Resource.Status.SUCCESS && !response.data.isNullOrEmpty()).isTrue()
    }

    @Test
    fun `Check if status is not successful due to a failure`() = runBlocking {
        fakeDataSourceFake.testForError = true
        val response = getDevicesUseCase().first()

        assertThat(response.status == Resource.Status.ERROR).isTrue()
    }

    @Test
    fun `Check if status is its failure and data not available`() = runBlocking {
        fakeDataSourceFake.testForError = true
        val response = getDevicesUseCase().first()

        assertThat(response.status == Resource.Status.ERROR && response.data.isNullOrEmpty()).isTrue()
    }
}