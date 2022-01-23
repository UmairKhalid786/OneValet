package com.techlad.onevalet.presentation.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * Created by umair.khalid on 21,January,2022
 **/

@Composable
fun SettingItem(
    text: String,
) {
    var isChecked by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(PaddingValues(start = 32.dp, 16.dp, 32.dp, 16.dp)),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = text, Modifier.weight(1f))

        Switch(checked = isChecked, onCheckedChange = {
            scope.launch {
                isChecked = it
            }
        })
    }
}