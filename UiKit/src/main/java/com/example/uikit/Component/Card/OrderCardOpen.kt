package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Buttons.MediumButton
import com.example.uikit.Component.Spacers.SpacerH
import com.example.uikit.Component.Spacers.SpacerW
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun OrderClassOpen(
    numberOrder: String,
    cost: String,
    date: String,
    state: Boolean,
    onClick:()->Unit,
    onClickCheck:()->Unit,
    onClickHelp:()->Unit,
    onClickExit:()->Unit,

    content: @Composable () -> Unit
){

    var stateOpen by remember { mutableStateOf(state) }
    Box( Modifier.fillMaxSize().background(Black.copy(alpha = 0.6f)).padding(20.dp), contentAlignment = Alignment.Center) {

        CardBackground {
            Column() {
                Column(
                    modifier = Modifier.fillMaxWidth().height(133.dp).padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text("Заказ № $numberOrder", style = Typography().Title3Semibold, color = Black)

                        Text("$cost ₽", style = Typography().HeadlineRegular, color = Black)

                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(date, style = Typography().CaptionRegular, color = Color(0xff939396))

                        SpacerW(6)

                        Box(Modifier.size(5.dp).clip(CircleShape).background(Color(0xff939396)))

                        SpacerW(6)

                        Text("Оплачено", style = Typography().CaptionRegular, color = Accent)
                    }

                    Row(modifier = Modifier.clickable { onClick()
                        stateOpen = !stateOpen
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.icon_plus),
                            contentDescription = null, tint = Color(0xff939396)
                        )
                        SpacerW(8)

                        Text(
                            "Посмотреть",
                            style = Typography().HeadlineRegular,
                            color = Color(0xff939396)
                        )
                    }

                }

                if (stateOpen) {

                    Box(Modifier.fillMaxWidth().height(1.dp).background(Color(0xffF4F4F4)))

                    Column(Modifier.fillMaxWidth().padding(16.dp)) {

                        Text("Описание", style = Typography().HeadlineMedium, color = Placeholder)
                        SpacerH(12)

                        content()

                        SpacerH(22)
                        Box(Modifier.fillMaxWidth().height(1.dp).background(Color(0xffF4F4F4)))
                        SpacerH(22)

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            MediumButton({ onClickCheck() }, false, "Чек покупки", 0.5f)
                            MediumButton({ onClickHelp() }, false, "Помощь", 1f)
                        }
                        SpacerH(16)
                        MediumButton({ onClickExit() }, true, "Закрыть", 1f)


                    }
                }
            }
        }

    }

}
@Preview
@Composable
fun PreviewOrderClassOpen(){


    Column(modifier = Modifier.fillMaxSize()) {
        OrderClassOpen("123456","300", "26 апреля, 14:00", false, {}, {},{},{},{})
    }

}