package com.example.uikit.Component.Buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Spacers.SpacerW
import com.example.uikit.R
import com.example.uikit.UI.Description
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorBigButton

@Composable
fun CartButton(
    text: String,
    cost: String,
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
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row() {
                Icon(
                    painter = painterResource(R.drawable.icon_shopping_cart),
                    contentDescription = null, tint = White,
                )
                SpacerW(16)
                Text(text = text, style =  Typography().Title3Semibold, color = White)
            }
            Text("${cost} ₽" , style =  Typography().Title3Semibold, color = White)
        }

    }
}