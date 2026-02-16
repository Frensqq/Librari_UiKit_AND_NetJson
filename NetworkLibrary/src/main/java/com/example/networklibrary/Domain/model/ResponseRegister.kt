package com.example.networklibrary.Domain.model

import android.net.Uri

data class ResponseRegister (
    val id:	String,
    val collectionId:	String,
    val collectionName:	String,
    val created:	String,
val updated:	String,
val email:	String,
val emailVisibility:	Boolean = false,
val verified:	Boolean = false,
val first_name:	String,
val last_name:	String,
val patronymic:	String,
val birthday:	String,
val gender:	String,
)