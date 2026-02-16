package com.example.networklibrary.Domain.model


data class ResponseBasket (

    val page: Int,
    val perPage	: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<Basket>,

    )