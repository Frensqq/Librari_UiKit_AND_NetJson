package com.example.networklibrary.Domain.model

import android.net.Uri

data class Project (
    val id: String,
    val collectionId:	String,
    val collectionName:	String,
    val created:	String,
    val updated:	String,
    val title:	String,
    val type:	String,
    val date_start:	String,
    val date_end:	String,
    val size:	String,
    val description_source	:	String,
    val technical_drawing:	String,
    val user_id: String
)