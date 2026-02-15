package com.example.uikit.UI


import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.graphics.Color



val Accent = Color(0xff00C07F)
val AccentInactive = Color(0xff63D4B0)
val Black = Color(0xff000000)
val White = Color(0xffffffff)
val Error = Color(0xffFD3535)
val Success = Color(0xff00B712)
val InputBg = Color(0xffF5F5F9)
val InputStr = Color(0xffEBEBEB)
val InputIcon = Color(0xffB8C1CC)
val Placeholder = Color(0xff939396)
val Description = Color(0xff7E7E9A)
val CardStr = Color(0xffF4F4F4)


fun colorBigButton() = ButtonDefaults.buttonColors(
    containerColor = Accent,
    contentColor = White,
    disabledContainerColor = AccentInactive,
    disabledContentColor = White
)

fun colorSmallButton() = ButtonDefaults.buttonColors(
    containerColor = White,
    contentColor = Accent,
    disabledContainerColor = White,
    disabledContentColor = AccentInactive
)
fun colorChipsButton() = ButtonDefaults.buttonColors(
    containerColor = InputBg,
    contentColor = Description,
    disabledContainerColor = InputBg,
    disabledContentColor = Description
)

fun colorTextField() = OutlinedTextFieldDefaults.colors(
    unfocusedContainerColor = InputBg,
    focusedContainerColor = InputBg,
    errorContainerColor = Error.copy(alpha = 0.6f),

    unfocusedBorderColor = InputStr,
    focusedBorderColor = Accent,
    errorBorderColor = Accent,

    cursorColor = Accent,
    errorCursorColor = Accent,

    unfocusedPlaceholderColor = Placeholder,
    focusedPlaceholderColor = Placeholder,
    errorPlaceholderColor = Placeholder,

    unfocusedTextColor = Black,
    focusedTextColor = Black,
    errorTextColor = Black,
)