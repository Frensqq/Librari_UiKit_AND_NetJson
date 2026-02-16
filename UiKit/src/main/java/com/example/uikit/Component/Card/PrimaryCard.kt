package com.example.uikit.Card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.SmallButton
import com.example.uikit.Components.SpacerH
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography

@Composable
fun PrimaryCard(titleText: String,stateButton: Boolean , onClick:() -> Unit,onClickCard:() -> Unit, Type: String, cost: String){

    CardBackground {
        Column(modifier = Modifier.height(138.dp).fillMaxWidth().padding(16.dp)
            .clickable{onClickCard()}, verticalArrangement = Arrangement.SpaceBetween) {

            Text(titleText, style = Typography().HeadlineMedium)

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom) {
                Column(
                    Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    SpacerH(16)
                    Text(Type, style = Typography().CaptionSemibold, color = Placeholder)

                    Text("$cost ₽", style = Typography().Title3Semibold)
                }

                SmallButton( if (stateButton) "Добавить" else "Убрать"
                    , onClick,stateButton )
            }

        }
    }

}

@Preview
@Composable
fun PreviewPrimaryCard(){

   var cost by remember { mutableStateOf(0) }

    Column() {
        PrimaryCard("Рубашка Воскресенье для машинного \n" +
                "вязания",false, {},{ cost = cost+100 }, "Мужская одежда", cost.toString())
    }

}
