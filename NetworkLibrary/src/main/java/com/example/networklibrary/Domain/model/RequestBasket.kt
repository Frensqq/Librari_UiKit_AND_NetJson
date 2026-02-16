package com.example.networklibrary.Domain.model

data class RequestBasket (
    val user_id: String,
    val items: String? = null,
    val count: Int
)