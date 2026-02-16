package com.example.uikit.Controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.InputStr

@Composable
fun Counter(count:Int, countChange:(Int)->Unit){

    Row(Modifier.width(64.dp).height(32.dp)
        .clip(RoundedCornerShape(8.dp)).background(InputBg)
        .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){

        Icon(
            painter = painterResource(R.drawable.icon_minus),
            contentDescription = null,
            tint = if (count <= 0) Color(0xffB8C1CC) else Color(0xff939396),
            modifier = Modifier.clickable{countChange(count-1)}
        )

        Box(Modifier.width(1.dp).height(16.dp).background(InputStr))

        Icon(
            painter = painterResource(R.drawable.icon_plus),
            contentDescription = null,
            tint = Color(0xff939396),
            modifier = Modifier.clickable{countChange(count+1)}
        )
    }
}
