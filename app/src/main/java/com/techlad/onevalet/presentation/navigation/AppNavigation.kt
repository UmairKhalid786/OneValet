package com.techlad.onevalet.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techlad.onevalet.presentation.home.HomeScreen

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Home.title) {
        // e.g will add auth routes here if when we will extend project
        composable(Screens.Home.title) { HomeScreen() }
    }
}