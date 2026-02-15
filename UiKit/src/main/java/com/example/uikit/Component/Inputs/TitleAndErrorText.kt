package com.example.uikit.Component.Inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.uikit.Component.Spacers.SpacerH
import com.example.uikit.UI.Error
import com.example.uikit.UI.Typography
import kotlin.text.isNullOrEmpty

@Composable
fun TitleAndErrorText(isError: Boolean,
                      content: @Composable ()-> Unit,
                      errorText: String?,
                      text: String?){
    Column() {
        if (!text.isNullOrEmpty()) {
            Text(
                text, style = Typography().CaptionRegular,
                color = Color(0xff939396)
            )
            SpacerH(6)
        }
        content()
        if (!errorText.isNullOrEmpty() && isError) {
            SpacerH(8)
            Text(
                errorText, style = Typography().CaptionRegular,
                color = Error
            )
        }
    }
}