package com.example.networklibrary

import com.example.networklibrary.Data.remote.PBApi
import com.example.networklibrary.Data.remote.PBApiServis
import com.example.networklibrary.Domain.model.Basket
import com.example.networklibrary.Domain.model.RequestAuth
import com.example.networklibrary.Domain.model.RequestBasket
import com.example.networklibrary.Domain.model.RequestBasketUpdate
import com.example.networklibrary.Domain.model.RequestRegister
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.UUID

// Класс для товара в корзине

data class BasketResponse(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val user_id: String,
    val items: List<CartItem>,  // Изменено: теперь список, а не строка
    val count: Int
)

data class CartItem(
    val productId: String,
    val name: String,
    val price: Int,
    val quantity: Int
)

class BasketTests {
    private lateinit var api: PBApi
    private val gson = Gson()
    private var testUserId = ""

    @Before
    fun setup() = runBlocking {
        api = PBApiServis.instance
        val email = "test@example.com"
        //val register = api.Register(RequestRegister(email, "password123", "password123"))
        //testUserId = register.id

        val auth = api.Auth(RequestAuth(email, "password123"))
        testUserId = auth.record.id

        PBApiServis.setAuthToken(auth.token)
    }

    private suspend fun getProductId() = api.getProducts("id != 'null'", 1, 1, "+created").items.first().id

    @Test
    fun testCreateBasket() = runBlocking {
        val productId = getProductId()
        val items = listOf(CartItem(productId, "Рубашка", 2999, 2),
                CartItem(productId, "Кофта", 3001, 3),
            CartItem(productId, "Штаны", 4000, 4),
            )

        val request = RequestBasket(testUserId, gson.toJson(items), items.size)
        val response = api.postBasket(request)

        // Конвертируем ответ в BasketResponse
        val basket = gson.fromJson(gson.toJson(response), BasketResponse::class.java)

        assertNotNull(basket.id)
        assertEquals(testUserId, basket.user_id)
        assertEquals(1, basket.items.size)
        assertEquals(productId, basket.items[0].productId)
    }


    @Test
    fun testGetUserBaskets() = runBlocking {
        // Создаем несколько корзин для пользователя
        val productId = getProductId()

        // Корзина 1
        val items1 = listOf(CartItem(productId, "Рубашка", 2999, 2))
        api.postBasket(RequestBasket(testUserId, gson.toJson(items1), items1.size))

        // Корзина 2
        val items2 = listOf(CartItem(productId, "Джинсы", 4999, 1))
        api.postBasket(RequestBasket(testUserId, gson.toJson(items2), items2.size))

        // Получаем все корзины пользователя
        val response = api.getBaskets("-created")

        println("📊 Всего корзин: ${response.totalItems}")
        println("📦 Список корзин пользователя $testUserId:")

        response.items.forEachIndexed { index, basket ->
            val basketJson = gson.toJson(basket)
            val basketData = gson.fromJson(basketJson, BasketResponse::class.java)

            println("  ${index + 1}. Корзина ID: ${basketData.id}")
            println("     Создана: ${basketData.created}")
            println("     Товаров: ${basketData.count}")
            println("     Состав:")
            basketData.items.forEach { item ->
                println("       - ${item.name} (${item.productId}): ${item.price}₽ x${item.quantity}")
            }
        }

        assertTrue(response.items.isNotEmpty())
    }


//    @Test
//    fun testDeleteBasket() = runBlocking {
//        val productId = getProductId()
//        val items = listOf(CartItem(productId, "Рубашка", 2999, 1))
//
//        val create = api.postBasket(RequestBasket(testUserId, gson.toJson(items), items.size))
//        val basket = gson.fromJson(gson.toJson(create), BasketResponse::class.java)
//
//        api.deleteBasket(basket.id)
//
//        try {
//            api.getBasket(basket.id)
//            fail()
//        } catch (e: Exception) {
//            assertTrue(true)
//        }
//    }
}