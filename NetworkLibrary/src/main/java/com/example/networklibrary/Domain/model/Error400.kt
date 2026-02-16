package com.example.networklibrary.Domain.model

data class Error400 (
    val status: Int,
    val message: String,
    val data: Map<String, Any>? = mapOf()
)