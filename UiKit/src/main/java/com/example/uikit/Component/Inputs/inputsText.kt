package com.example.uikit.Component.Inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorTextField

@Composable
fun textInput(
    values: String,
    onChangeValue: (String) -> Unit,
    placeholder: String,
    isError: Boolean = false,
    isPass: Boolean = false,
){

    var passView by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = values,
        onValueChange = {onChangeValue(it)},
        modifier = Modifier.fillMaxWidth().height(48.dp),
        shape = RoundedCornerShape(10.dp),
        isError = isError,
        visualTransformation = if (passView && isPass){
            PasswordVisualTransformation()
        }else VisualTransformation.None,
        colors = colorTextField(),
        textStyle = Typography().TextRegular,
        trailingIcon = {
            if (isPass){Icon(
                painter = painterResource(if (!passView) R.drawable.eyeopen else R.drawable.icon_eyeclose),
                contentDescription = null, tint = Black,
                modifier = Modifier.clickable{passView = !passView}
            )}
        },
        placeholder = { Text(placeholder, style = Typography().TextRegular, color = Color(0xff939396)) },)
    }
