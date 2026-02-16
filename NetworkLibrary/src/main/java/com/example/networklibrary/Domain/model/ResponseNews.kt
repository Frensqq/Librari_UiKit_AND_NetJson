package com.example.networklibrary.Domain.model

import android.net.Uri

data class ResponseNews (
    val page: Int,
    val perPage	: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<News>,
)