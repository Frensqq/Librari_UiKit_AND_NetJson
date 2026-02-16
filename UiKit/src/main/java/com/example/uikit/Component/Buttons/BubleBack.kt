package com.example.uikit.Component.Buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorBigButton
import com.example.uikit.UI.colorChipsButton

@Composable
fun BubbleBack(
    onClick: () -> Unit,
){
    Box( modifier = Modifier
        .size(32.dp).clip(RoundedCornerShape(8.dp))
        .clickable{onClick()}.background(InputBg),
        contentAlignment = Alignment.Center

        ) {
        Icon(
            painter = painterResource(R.drawable.icon_chevron_left),
            contentDescription = null, tint = Description,
        )
    }
}