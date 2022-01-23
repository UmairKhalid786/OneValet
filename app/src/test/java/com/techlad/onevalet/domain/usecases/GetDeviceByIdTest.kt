package com.techlad.onevalet.domain.usecases

import com.google.common.truth.Truth
import com.techlad.onevalet.data.datasource.FakeDevicesDataSource
import com.techlad.onevalet.data.repository.FakeDevicesRepository
import com.techlad.onevalet.exceptions.InvalidOperationException
import com.techlad.onevalet.utils.Resource
import com.techlad.onevalet.utils.Resource.Status.SUCCESS
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDeviceByIdTest {

    private lateinit var useCase: GetDeviceById
    private lateinit var repository: FakeDevicesRepository
    private lateinit var fakeDataSourceFake: FakeDevicesDataSource

    companion object {
        private const val ID_AVAILABLE_IN_DUMMY_DATA = "1"
        private const val ID_NOT_AVAILABLE_IN_DUMMY_DATA = "100"
    }

    @Before
    fun setUp() {
        fakeDataSourceFake = FakeDevicesDataSource()
        repository = FakeDevicesRepository(fakeDataSourceFake)
        useCase = GetDeviceById(repository)
    }

    @Test
    fun `Check if device response is not null with given id`() = runBlocking {
        val device = useCase(ID_AVAILABLE_IN_DUMMY_DATA).first().data
        Truth.assertThat(device != null).isTrue()
    }

    @Test
    fun `Check if device response is not null with given id and status is successful`() =
        runBlocking {
            val response = useCase(ID_AVAILABLE_IN_DUMMY_DATA).first()

            Truth.assertThat(response.data != null && response.status == SUCCESS)
                .isTrue()
        }

    @Test
    fun `Check if device response device have same id`() = runBlocking {
        val device = useCase(ID_AVAILABLE_IN_DUMMY_DATA).first().data
        Truth.assertThat(device != null && device.id == ID_AVAILABLE_IN_DUMMY_DATA).isTrue()
    }

    @Test
    fun `Check if status is successful`() = runBlocking {
        val status = useCase(ID_AVAILABLE_IN_DUMMY_DATA).first().status
        Truth.assertThat(status == SUCCESS).isTrue()
    }

    @Test
    fun `Check if status is successful and data is not available`() = runBlocking {
        val response = useCase(ID_AVAILABLE_IN_DUMMY_DATA).first()

        Truth.assertThat(response.status == SUCCESS && response.data == null)
            .isFalse()
    }


    @Test
    fun `Check if throw exception due empty id`() = runBlocking {
        try {
            val response = useCase("").first()
            Truth.assertThat(response.data == null).isTrue()
        } catch (e: InvalidOperationException) {
            Truth.assertThat(true).isTrue()
        }
    }

    @Test
    fun `Check if status is failure due to wrong id`() = runBlocking {
        val response = useCase(ID_NOT_AVAILABLE_IN_DUMMY_DATA).first()

        Truth.assertThat(response.status == Resource.Status.ERROR && response.data == null)
            .isTrue()
    }
}