package com.example.uikit.Component.Buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorBigButton

@Composable
fun BigButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = colorBigButton(),
        modifier = Modifier.fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(10.dp),

    ) {
        Text(text = text, style =  Typography().Title3Semibold, color = White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center)
    }
}