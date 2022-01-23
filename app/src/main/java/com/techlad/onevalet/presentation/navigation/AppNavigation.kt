package com.techlad.onevalet.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techlad.onevalet.presentation.home.HomeScreen
import com.techlad.onevalet.presentation.splash.SplashScreen

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Splash.title) {
        composable(Screens.Splash.title) { SplashScreen(navController) }
        composable(Screens.Home.title) { HomeScreen() }
    }
}