package com.example.networklibrary.Domain.model

import android.net.Uri

data class RequestProject (
    val title:	String,
    val type:	String,
    val date_start:	String,
    val date_end:	String,
    val size:	String,
    val description_source	:	String,
val technical_drawing:	Uri,
val user_id:	String,
)