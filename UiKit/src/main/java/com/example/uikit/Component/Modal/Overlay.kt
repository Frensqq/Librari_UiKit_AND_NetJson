package com.example.uikit.Component.Modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.uikit.UI.Black

@Composable
fun Overlay(
    content: @Composable () -> Unit
){
    Box(modifier = Modifier.fillMaxSize().background(Black.copy(alpha = 0.6f)),
        contentAlignment = Alignment.BottomCenter){
        content()
    }
}