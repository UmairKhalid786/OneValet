package com.techlad.onevalet.domain.usecases

import com.google.common.truth.Truth
import com.techlad.onevalet.data.datasource.FakeDevicesDataSource
import com.techlad.onevalet.data.repository.FakeDevicesRepository
import com.techlad.onevalet.exceptions.InvalidOperationException
import com.techlad.onevalet.utils.Resource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchDevicesTest {
    private lateinit var useCase: SearchDevices
    private lateinit var repository: FakeDevicesRepository
    private lateinit var fakeDataSourceFake: FakeDevicesDataSource

    companion object {
        private const val CONTENT_AVAILABLE_IN_DUMMY_DATA = "iphone"
        private const val CONTENT_NOT_AVAILABLE_IN_DUMMY_DATA = "bbsdshdaskdjh"
    }

    @Before
    fun setUp() {
        fakeDataSourceFake = FakeDevicesDataSource()
        repository = FakeDevicesRepository(fakeDataSourceFake)
        useCase = SearchDevices(repository)
    }

    @Test
    fun `Check if device response is not null with given text`() = runBlocking {
        val devices = useCase(CONTENT_AVAILABLE_IN_DUMMY_DATA).first().data
        Truth.assertThat(devices != null).isTrue()
    }

    @Test
    fun `Check if devices response is not null with given text and status is successful`() =
        runBlocking {
            val response = useCase(CONTENT_AVAILABLE_IN_DUMMY_DATA).first()

            Truth.assertThat(response.data != null && response.status == Resource.Status.SUCCESS)
                .isTrue()
        }

    @Test
    fun `Check if devices response device contains given text`() = runBlocking {
        val device = useCase(CONTENT_AVAILABLE_IN_DUMMY_DATA).first().data

        Truth.assertThat(
            device?.firstOrNull()?.let {
                (it.title.contains(CONTENT_AVAILABLE_IN_DUMMY_DATA, true) || it.description.contains(CONTENT_AVAILABLE_IN_DUMMY_DATA, true))
            } ?: false
        ).isTrue()
    }

    @Test
    fun `Check if status is successful`() = runBlocking {
        val status = useCase(CONTENT_AVAILABLE_IN_DUMMY_DATA).first().status
        Truth.assertThat(status == Resource.Status.SUCCESS).isTrue()
    }

    @Test
    fun `Check if status is successful and data is not available`() = runBlocking {
        val response = useCase(CONTENT_AVAILABLE_IN_DUMMY_DATA).first()

        Truth.assertThat(response.status == Resource.Status.SUCCESS && response.data == null)
            .isFalse()
    }


    @Test
    fun `Check if throw exception due empty text`() = runBlocking {
        try {
            val response = useCase("").first()
            Truth.assertThat(response.data == null).isTrue()
        } catch (e: InvalidOperationException) {
            Truth.assertThat(true).isTrue()
        }
    }

    @Test
    fun `Check if status is failure due to wrong text`() = runBlocking {
        val response = useCase(CONTENT_NOT_AVAILABLE_IN_DUMMY_DATA).first()

        Truth.assertThat(response.status == Resource.Status.ERROR && response.data == null)
            .isTrue()
    }
}