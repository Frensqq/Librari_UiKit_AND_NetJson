package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.White

@Composable
fun CardBackground(content: @Composable () -> Unit){

    Box(modifier = Modifier.heightIn(116.dp)
        .fillMaxWidth()
        .dropShadow(
            shape = RoundedCornerShape(12.dp),
            shadow = Shadow(radius = 8.dp, spread = 2.dp,  color = Color(0x99E4E8F5).copy(alpha = 0.6f)) )
        .background(color = White, shape = RoundedCornerShape(12.dp))) {

        content()

    }

}

@Preview
@Composable
fun PreviewCardBackground(){

    Column(modifier = Modifier.fillMaxSize().background(White).padding(20.dp)) {
        CardBackground({})
    }

}

