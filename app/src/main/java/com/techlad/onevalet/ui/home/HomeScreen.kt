package com.techlad.onevalet.ui.home

import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.techlad.onevalet.R
import com.techlad.onevalet.ui.dialogs.SimpleDialog
import com.techlad.onevalet.ui.navigation.AppBar
import com.techlad.onevalet.ui.navigation.Screens
import com.techlad.onevalet.ui.navigation.menu.BackLayerMenu
import kotlinx.coroutines.launch

/**
 * Created by umair.khalid on 15,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()

    val openDialog = remember { mutableStateOf(false) }

    val scaffoldState = rememberBackdropScaffoldState(
        BackdropValue.Concealed
    )

    val scope = rememberCoroutineScope()

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = {
            AppBar(scaffoldState, scope)
        },
        backLayerContent = {
            BackLayerMenu(modifier) {
                scope.launch {
                    scaffoldState.conceal()
                    navigationHandler(it, navHostController, openDialog)
                }
            }
        },
        frontLayerContent = {
            HomeContent(navHostController)
        }
    )

    if (openDialog.value) {
        SimpleDialog(
            title = LocalContext.current.getString(R.string.about_title),
            message = LocalContext.current.getString(R.string.about_one_valet)) {
            openDialog.value = false
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
    openDialog: MutableState<Boolean>,
) {
    when (address) {
        Screens.About.title -> {
            openDialog.value = true
        }
        else -> {
            address?.let { navHostController.navigate(it) }
        }
    }
}
