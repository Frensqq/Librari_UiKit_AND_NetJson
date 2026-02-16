package com.example.uikit.Component.Header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Buttons.BubbleBack
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Typography

@Composable
fun Header(onBack:()-> Unit, onDelete:()->Unit){

    Column(
        modifier = Modifier.fillMaxWidth().height(84.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        BubbleBack { onBack() }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Корзина", style = Typography().Title1Heavy, color = Black)

            Icon(
                painter = painterResource(R.drawable.icon_close),
                contentDescription = null, tint = Color(0xffB8C1CC), modifier = Modifier.clickable {
                    onDelete()
                })
        }
    }

}

@Preview
@Composable
fun PreviewBlockHeader(){

    Column() {
        Header({}, {})
    }

}