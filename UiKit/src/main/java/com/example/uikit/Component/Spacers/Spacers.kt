package com.example.uikit.Component.Spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun SpacerH(height: Int){
    Spacer(modifier = Modifier.height(height.dp))
}

fun SpacerW(width: Int){
    Spacer(modifier = Modifier.width(width.dp))
}