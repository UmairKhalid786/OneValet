package com.techlad.onevalet.presentation.navigation.menu

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString

/**
 * Created by umair.khalid on 16,January,2022
 **/

@Composable
fun MenuItem(title: String, onClick: (Int) -> Unit) {
    ClickableText(text = AnnotatedString(title),
        onClick = onClick,
        style = MaterialTheme.typography.h6)
}