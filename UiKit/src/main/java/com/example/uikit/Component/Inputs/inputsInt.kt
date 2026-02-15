package com.example.uikit.Component.Inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorTextField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.Key

@Composable
fun inputsInt(
    value: String,
    onChangeValue: (String) -> Unit,
    focus: FocusRequester,
    focusList: List<FocusRequester>,
    index: Int
){

    OutlinedTextField(
        value = value,
        onValueChange = {new ->
            if (new.length <= 1) {
                val old = value
                if (new.isNotEmpty() && old.isEmpty() && (index < focusList.size -1)) {
                    CoroutineScope(Dispatchers.Main).launch {
                        focusList[index+1].requestFocus()
                    }
                }else  if (index > 0) {
                    CoroutineScope(Dispatchers.Main).launch {
                        focusList[index-1].requestFocus()
                    }
                }
            }
        },
        modifier = Modifier.size(48.dp).focusRequester(focus),
        shape = RoundedCornerShape(10.dp),
        colors = colorTextField(),
        textStyle = Typography().TextRegular,
        placeholder = { Text(text = "1", style = Typography().TextRegular,
            modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center,
            color = Placeholder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
}