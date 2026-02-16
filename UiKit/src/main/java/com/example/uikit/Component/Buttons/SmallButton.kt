package com.example.uikit.Component.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorBigButton
import com.example.uikit.UI.colorSmallButton

@Composable
fun SmallButton(
    text: String,
    onClick: () -> Unit,
    state: Boolean = true
){

    Button(
        onClick = onClick,
        colors = if (state) colorBigButton() else colorSmallButton(),
        modifier = Modifier.width(96.dp).height(40.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Accent ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)

        ) {
        Text(text = text, style =  Typography().CaptionSemibold, color = if (state) White else Accent,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)
    }


}