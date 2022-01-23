package com.techlad.onevalet.presentation.dialogs

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Composable
fun SimpleDialog(
    title: String,
    message: String,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
            onDismiss()
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(text = message)
        },
        confirmButton = {

        },
        dismissButton = {
            Button(
                onClick = {
                    onDismiss()
                }) {
                Text("Ok")
            }
        }
    )
}