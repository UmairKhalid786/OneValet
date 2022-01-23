package com.techlad.onevalet.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.techlad.onevalet.R
import com.techlad.onevalet.presentation.navigation.Screens
import kotlinx.coroutines.delay

/**
 * Created by umair.khalid on 15,January,2022
 **/

private const val SplashWaitTime: Long = 2000

@Composable
fun SplashScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        // Adds composition consistency. Use the value when LaunchedEffect is first called
        val currentOnTimeout by rememberUpdatedState {
            navHostController.navigate(Screens.Home.title)
        }

        LaunchedEffect(Unit) {
            delay(SplashWaitTime)
            currentOnTimeout()
        }
        Image(painterResource(id = R.drawable.ic_splash), contentDescription = null)
    }
}
