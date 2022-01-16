package com.techlad.onevalet.ui.devices.devices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techlad.onevalet.R
import com.techlad.onevalet.data.Device

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun DeviceCard(device: Device, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface,
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = device.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(66.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = device.title,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = device.description,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun DeviceCardPreview() {
    DeviceCard(Device(1, "Hi", R.drawable.ic_phone, "This is dummy description")) {

    }
}