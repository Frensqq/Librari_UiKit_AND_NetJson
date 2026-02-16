package com.example.uikit.Component.Search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Description

@Composable
fun SearchAndIcon(values: String,
                  onChangeValue: (String) -> Unit,
                  placeholder: String,
                  onClickCart: () -> Unit){

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Search(values, onChangeValue, placeholder, 0.7f )

        Icon(
            painter = painterResource(R.drawable.icon_shopping_cart ),
            contentDescription = null, tint = Accent,
            modifier = Modifier.size(20.dp).padding(horizontal = 14.dp).clickable{onClickCart()}
        )
    }
}