package com.example.uikit.Component.Inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Typography


@Composable
fun inputsImage(
    OnClick: () -> Unit,
    content: @Composable () -> Unit,
    paint: Painter?,
    state: Boolean = false

){
    Row(
        modifier = Modifier.fillMaxWidth().height(if (!state)48.dp else 172.dp )
            .padding(horizontal = if (state) 34.dp else 0.dp).clip(RoundedCornerShape(10.dp))
            .background(InputBg)
            .border(1.dp, InputStr, RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween, verticalAlignment = Alignment.CenterVertically

    ){

        if (!state) {
            Text(
                text = "Загрузить", style = Typography().HeadlineRegular,
                modifier = Modifier.padding(horizontal = 14.dp)
            )

            Icon(
                painter = painterResource(R.drawable.icon_plus),
                contentDescription = null, tint = Black,
                modifier = Modifier.padding(horizontal = 14.dp).clickable { OnClick() }
            )
        }
        else{
            if (paint == null){
                content()
            }
            else{

                Image(painter = paint, contentDescription = null,
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    contentScale = ContentScale.FillWidth)
            }
        }
    }
}