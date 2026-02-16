package com.example.uikit.Component.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Error
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorBigButton

@Composable
fun MediumButton(
    onClick:()->Unit,
    state: Boolean,
    text: String,
    width: Float
){
    Button(
        onClick = onClick,
        modifier = Modifier.height(48.dp).fillMaxWidth(width),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
        colors = if (state) colorBigButton() else
            ButtonDefaults.buttonColors(
                containerColor = InputBg,
                contentColor = Black
            ),
        border = if (state) BorderStroke(1.dp, Error)
        else {
            BorderStroke(0.dp, InputBg)
        },
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp),
    )
    {
        Text(text, style = Typography().TextMedium, color = if (state) Error else Black)
    }

}