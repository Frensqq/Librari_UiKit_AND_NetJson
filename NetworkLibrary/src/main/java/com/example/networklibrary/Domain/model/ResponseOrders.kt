package com.example.networklibrary.Domain.model


data class ResponseOrders (

    val page: Int,
    val perPage	: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<Order>,

    )