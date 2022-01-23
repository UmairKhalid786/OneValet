package com.techlad.onevalet.presentation.settings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Composable
fun SettingsScreen() {
    LazyColumn {
        items(10) {
            SettingItem("Settings $it")
        }
    }
}