package com.example.networklibrary.Domain.model

data class ResponseAuth (
    val record: User,
    val token: String
)