package com.example.uikit.Component.Selects

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Component.Spacers.SpacerH
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorTextField
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun selectDate(
    value: String,
    listValue: List<String>,
    onValueChange: (String) -> Unit,
    placeholder: String,
    Title: String? = null
){
    var state by remember { mutableStateOf(false) }

    Column() {
        if (!Title.isNullOrEmpty()){
            Text(text = Title, style = Typography().CaptionRegular, color = Description)
        }
        SpacerH(4)
        OutlinedTextField(
            readOnly = true,
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(10.dp),
            colors = colorTextField(),
            textStyle = Typography().TextRegular,
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icon_chevron_down),
                    contentDescription = null, tint = Black,
                    modifier = Modifier.clickable {
                        state = !state
                    }
                )
            },
            placeholder = {
                Text(
                    placeholder,
                    style = Typography().TextRegular,
                    color = Color(0xff939396)
                )
            },
        )


            DropdownMenu(modifier = Modifier.fillMaxWidth(),
                onDismissRequest = {state = false},
                expanded = state,
                ){
                listValue.forEach { items ->
                    DropdownMenuItem(
                        text = {Text(text = items)},
                        onClick = {onValueChange(items)
                            state = false
                        }
                    )

                }
            }

    }
}