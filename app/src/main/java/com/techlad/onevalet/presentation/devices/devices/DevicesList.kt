package com.techlad.onevalet.presentation.devices.devices

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.techlad.onevalet.domain.model.Device
import com.techlad.onevalet.presentation.home.SearchAppBar
import com.techlad.onevalet.utils.TestTags.DEVICES_LIST

/**
 * Created by umair.khalid on 16,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun DevicesList(
    list: List<Device>,
    onTextChange: (String) -> Unit,
    onDeviceClick: (Device) -> Unit,
) {

    var searchTextState by remember { mutableStateOf("") }

    LazyColumn(contentPadding = PaddingValues(16.dp), modifier = Modifier.testTag(DEVICES_LIST)) {
        item {
            SearchAppBar(searchTextState, onTextChange = {
                searchTextState = it
                onTextChange(it)
            }, onCloseClicked = {}, onSearchClicked = {})
        }
        items(list.size, {
            it.toString()
        }, itemContent = {
            DeviceCard(device = list[it]) {
                onDeviceClick(list[it])
            }
        })
    }
}