package com.techlad.onevalet.presentation.home

import android.os.Bundle
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techlad.onevalet.R
import com.techlad.onevalet.presentation.dialogs.SimpleDialog
import com.techlad.onevalet.presentation.navigation.AppBar
import com.techlad.onevalet.presentation.navigation.HomeNavigation
import com.techlad.onevalet.presentation.navigation.Screens
import com.techlad.onevalet.presentation.navigation.menu.BackLayerMenu
import kotlinx.coroutines.launch

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()

    var openDialog by remember { mutableStateOf(false) }
    var onDevicesScreen by remember { mutableStateOf(true) }

    val scaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        navHostController.addOnDestinationChangedListener(listener = { navController: NavController, navDestination: NavDestination, bundle: Bundle? ->
            onDevicesScreen = navDestination.route == Screens.Details.title
        })
    }

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            AppBar(scaffoldState, scope, onDevicesScreen) {
                navHostController.popBackStack()
            }
        },
        backLayerContent = {
            BackLayerMenu(modifier) {
                scope.launch {
                    scaffoldState.conceal()
                    if (it.equals(Screens.About.title, true))
                        openDialog = true
                    else
                        navigationHandler(it, navHostController)
                }
            }
        },
        frontLayerContent = {
            HomeNavigation(navHostController)
        }
    )

    if (openDialog) {
        SimpleDialog(
            title = LocalContext.current.getString(R.string.about_title),
            message = LocalContext.current.getString(R.string.about_one_valet)) {
            openDialog = false
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}

fun navigationHandler(
    address: String?,
    navHostController: NavHostController,
) {
    address?.let { navHostController.navigate(it) }
}
