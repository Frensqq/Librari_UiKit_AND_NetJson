package com.example.networklibrary.Domain.model

import android.net.Uri

data class Product (
    val id: String,
    val collectionId:	String,
    val collectionName:	String,
    val created:	String,
    val updated:	String,
    val title:	String,
    val price:	Number,
    val typeCloses:	String,
    val type:	String,
val description:	String,
val approximate_cost:	String,
)