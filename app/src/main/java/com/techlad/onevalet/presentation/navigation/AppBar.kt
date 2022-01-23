package com.techlad.onevalet.presentation.navigation

import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.techlad.onevalet.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by umair.khalid on 16,January,2022
 **/

@ExperimentalMaterialApi
@Composable
fun AppBar(
    scaffoldState: BackdropScaffoldState,
    scope: CoroutineScope,
    onDevicesScreen: Boolean,
    onBackPress: () -> Unit,
) {
    TopAppBar(
        title = { Text(LocalContext.current.getString(R.string.app_name)) },
        navigationIcon = {
            if (onDevicesScreen) {
                IconButton(
                    onClick = {
                        scope.launch { onBackPress() }
                    }
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = LocalContext.current.getString(R.string.close)
                    )
                }
            } else {
                if (scaffoldState.isConcealed) {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.reveal() }
                        }
                    ) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = LocalContext.current.getString(R.string.menu)
                        )
                    }
                } else {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.conceal() }
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = LocalContext.current.getString(R.string.close)
                        )
                    }
                }
            }
        },
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    )
}