package com.example.networklibrary.Domain.model

data class CartItem(
    val productId: String,
    val name: String,
    val price: Int,
    val quantity: Int
)
data class Basket (
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val user_id: String,
    val items: List<CartItem>,  // Изменено с String на List<CartItem>
    val count: Int

)