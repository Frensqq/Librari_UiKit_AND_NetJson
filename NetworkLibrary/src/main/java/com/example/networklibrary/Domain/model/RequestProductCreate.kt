package com.example.networklibrary.Domain.model

import android.net.Uri

data class RequestProductCreate (
    val title:	String,
    val price:	Number,
    val typeCloses:	String,
    val type:	String,
val description:	String,
val approximate_cost:	String,
)