package com.example.uikit.Component.Modal

import android.R
import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Buttons.BigButton
import com.example.uikit.Component.Spacers.SpacerH
import com.example.uikit.Component.Spacers.SpacerW
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun Modal(
    Title: String,
    onExit: () -> Unit,
    textButton: String,
    onClickButton: () -> Unit,
    description: String,
    aproxymateCost: String

){

    Column(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(White).padding(horizontal = 20.dp, vertical = 24.dp)

    ) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
            Text(text = Title, style = Typography().Title2Semibold, color = Black,
                modifier = Modifier.fillMaxWidth(0.75f))


            Box(modifier = Modifier.size(24.dp).clip(CircleShape)
                .background(InputBg).clickable{onExit()}) {
                Icon(
                    painter = painterResource(com.example.uikit.R.drawable.icon_close),
                    contentDescription = null, tint = Description,
                )
            }
        }
        SpacerH(20)
        Text(text = "Описание", style = Typography().HeadlineMedium, color = Placeholder,)
        SpacerH(8)
        Text(text = description, style = Typography().TextRegular,
            modifier = Modifier.height(336.dp), color = Black,)
        SpacerH(13)
        Text(text = "Примерный расход:", style = Typography().CaptionSemibold, color = Placeholder,)
        SpacerH(4)
        Text(text = aproxymateCost, style = Typography().HeadlineMedium, color = Black,)
        SpacerH(19)
        BigButton(textButton, onClickButton, true)
        SpacerH(16)
    }

}