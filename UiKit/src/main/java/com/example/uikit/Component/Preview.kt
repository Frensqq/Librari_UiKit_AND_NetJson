package com.example.uikit.Component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Component.Buttons.BubbleBack
import com.example.uikit.Component.Modal.Modal
import com.example.uikit.Component.Modal.Overlay
import com.example.uikit.Component.Search.Search
import com.example.uikit.Component.Search.SearchAndIcon

@Preview
@Composable
fun Preview(){
    var item by remember{ mutableStateOf("") }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(1){
            Search(
                values = item,
                onChangeValue = {item = it},
                "Поиск",
                1f
            )
            SearchAndIcon(
                values = item,
                onChangeValue = {item = it},
                "Поиск",
            ) { }

            BubbleBack({})

            Overlay { Modal("Рубашка воскресенье для \n" +
                    "машинного вязания", {},
                "Добавить за 690 ₽",
                {},
                "Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку.\n" +
                        "Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько.\n" +
                        "Пряжу 1400-1500м в 100г в 4 сложения, пряжу 700м в 2 сложения. Ориентир для конечной толщины – 300-350м в 100г.\n" +
                        "Артикулы, из которых мы вязали эту модель: Zermatt Zegna Baruffa, Cashfive, Baby Cashmere Loro Piana, Soft Donegal и другие.\n" +
                        "Примерный расход на шапку с подгибом 70-90г.",
                "80-90 г"
                ) }




        }
    }

}