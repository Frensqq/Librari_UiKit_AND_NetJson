package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Spacers.SpacerW
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Typography

@Composable
fun OrderClassClosed(
    numberOrder: String,
    cost: String,
    date: String,
    status: String,
    onClick:()->Unit
){

    CardBackground {

        Column(modifier = Modifier.height(116.dp).padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically ) {

                Text("Заказ № $numberOrder", style = Typography().Title3Semibold, color = Black)

                Text("$cost ₽", style = Typography().HeadlineRegular, color = Black)

            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(date, style = Typography().CaptionRegular, color = Color(0xff939396))

                SpacerW(6)

                Box(Modifier.size(5.dp).clip(CircleShape).background( Color(0xff939396)))

                SpacerW(6)

                Text(status, style = Typography().CaptionRegular, color = Accent)
            }

            Row(modifier = Modifier.clickable{onClick()}) {
                Icon(painter = painterResource(R.drawable.icon_close),
                    contentDescription = null , tint = Color(0xff939396))
                SpacerW(8)

                Text("Посмотреть", style = Typography().HeadlineRegular, color = Color(0xff939396))
            }

        }
    }
}
@Preview
@Composable
fun PreviewOrderClassClosed(){

    Column() {
        OrderClassClosed("123456","300", "26 апреля, 14:00", "Оплачен", {})
    }

}
