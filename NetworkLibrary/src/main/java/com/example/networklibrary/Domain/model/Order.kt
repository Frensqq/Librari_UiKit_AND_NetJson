package com.example.networklibrary.Domain.model

data class Order (
    val id:	String,
    val collectionId:	String,
    val collectionName:	String,
    val created:	String,
    val updated:	String,
    val user_id:	String,
    val items:	String,
    val total:	Number,

)