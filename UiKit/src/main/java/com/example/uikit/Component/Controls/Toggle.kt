package com.example.uikit.Controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Success
import com.example.uikit.UI.White

@Composable
fun Toggle(state: Boolean, onClick: ()->Unit){

    Box(Modifier.width(48.dp).height(28.dp).clip(CircleShape).background(color = if(!state) InputStr else Accent).padding(2.dp),
        contentAlignment = if (!state) Alignment.CenterStart else Alignment.CenterEnd){

        Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(White)
            .clickable{onClick()}
        )
    }
}