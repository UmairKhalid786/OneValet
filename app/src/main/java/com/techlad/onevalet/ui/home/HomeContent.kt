package com.techlad.onevalet.ui.home

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.techlad.onevalet.ui.navigation.DetailsParam
import com.techlad.onevalet.ui.navigation.HomeNavigation
import com.techlad.onevalet.ui.navigation.Screens

/**
 * Created by umair.khalid on 16,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun HomeContent(
    navHostController: NavHostController,
) {
    HomeNavigation(navHostController)
}
