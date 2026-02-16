package com.example.networklibrary.Domain.model

data class RequestRegister (
    val email: String,
    val password: String,
    val passwordConfirm: String
)