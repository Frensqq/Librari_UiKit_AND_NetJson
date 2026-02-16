package com.example.networklibrary.Domain.model

data class RequestOrder (
    val user_id: String,
    val items: String,
    val total: Number
)