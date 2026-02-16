package com.example.uikit.Component.Menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Buttons.ChipsButton
import com.example.uikit.Component.Spacers.SpacerW

@Composable
fun CategoryMenu(
    currentCat: String,
    listCategory: List<String>,
    onClick: (String) -> Unit
){

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { SpacerW(20) }
        items(listCategory){item ->
            ChipsButton(
                item,
                onClick = {onClick(item)},
                item == currentCat
            )
        }
        item { SpacerW(20) }
    }

}