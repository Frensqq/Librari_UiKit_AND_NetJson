package com.example.networklibrary.Domain.model

import android.net.Uri

data class RequestUserUpdate (
    val first_name: String,
    val last_name: String,
    val patronymic: String,
    val birthday	: String,
    val gender: String,
    val avatar: Uri
)