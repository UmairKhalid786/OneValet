package com.techlad.onevalet.presentation.navigation

import com.techlad.onevalet.presentation.navigation.DetailsParam.Companion.DEVICE_ID

sealed class Screens(val title: String) {
    object Home : Screens("home_screen")
    object Devices : Screens("devices_screen")
    object Settings : Screens("settings_screen")
    object About : Screens("about_screen")
    object Details : Screens("details_screen/{$DEVICE_ID}")
}

class DetailsParam {
    companion object {
        const val DEVICE_ID = "deviceId"
    }
}