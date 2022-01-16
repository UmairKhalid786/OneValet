package com.techlad.onevalet.ui.navigation

import com.techlad.onevalet.ui.navigation.DetailsParam.Companion.DEVICE_ID

sealed class Screens(val title: String) {
    object Splash : Screens("splash_screen")
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