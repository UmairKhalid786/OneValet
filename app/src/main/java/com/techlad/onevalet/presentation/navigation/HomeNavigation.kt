package com.techlad.onevalet.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.techlad.onevalet.presentation.devices.device_details.DeviceDetails
import com.techlad.onevalet.presentation.devices.devices.DevicesScreen
import com.techlad.onevalet.presentation.navigation.DetailsParam.Companion.DEVICE_ID
import com.techlad.onevalet.presentation.settings.SettingsScreen

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun HomeNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.Devices.title) {
        composable(Screens.Devices.title) {
            DevicesScreen(navController)
        }
        composable(Screens.Settings.title) {
            SettingsScreen()
        }
        composable(Screens.Details.title, arguments = listOf(navArgument(DEVICE_ID) {
            type = NavType.StringType
        })) {
            DeviceDetails(Modifier, it.arguments?.getString(DEVICE_ID))
        }
    }
}