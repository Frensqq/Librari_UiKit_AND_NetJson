package com.example.networklibrary

import com.example.networklibrary.Data.remote.PBApi
import com.example.networklibrary.Data.remote.PBApiServis
import com.example.networklibrary.Domain.model.RequestAuth
import com.example.networklibrary.Domain.model.RequestBasket
import com.example.networklibrary.Domain.model.RequestRegister
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.UUID






class BasketTeststWO {
    private lateinit var api: PBApi
    private val gson = Gson()
    private var testUserId = ""
    private var testUserEmail = ""

    @Before
    fun setup() = runBlocking {
        api = PBApiServis.instance
        testUserEmail = "test_${UUID.randomUUID()}@example.com"
        val register = api.Register(RequestRegister(testUserEmail, "password123", "password123"))
        testUserId = register.id
        val auth = api.Auth(RequestAuth(testUserEmail, "password123"))
        PBApiServis.setAuthToken(auth.token)
    }

    private suspend fun getProductId(): String {
        return try {
            api.getProducts("", 1, 1, "").items.first().id
        } catch (e: Exception) {
            "test_product_${UUID.randomUUID()}"
        }
    }

    @Test
    fun testCreateBasket() = runBlocking {
        val productId = getProductId()
        val items = listOf(CartItem(productId, "Рубашка", 2999, 2))

        val request = RequestBasket(testUserId, gson.toJson(items), items.size)
        val response = api.postBasket(request)
        val basket = gson.fromJson(gson.toJson(response), BasketResponse::class.java)

        assertEquals(1, basket.items.size)
        assertEquals(productId, basket.items[0].productId)
        println("✅ Корзина создана: ${basket.id}")
    }

    @Test
    fun testDeleteBasket() = runBlocking {
        val productId = getProductId()
        val items = listOf(CartItem(productId, "Рубашка", 2999, 1))

        val create = api.postBasket(RequestBasket(testUserId, gson.toJson(items), items.size))
        val basket = gson.fromJson(gson.toJson(create), BasketResponse::class.java)

        api.deleteBasket(basket.id)

        try {
            api.getBasket(basket.id)
            fail("Корзина должна быть удалена")
        } catch (e: Exception) {
            println("✅ Корзина удалена")
        }
    }

    @Test
    fun testGetAllBasketItems() = runBlocking {
        val productId = getProductId()
        val items = listOf(
            CartItem(productId, "Рубашка", 2999, 2),
            CartItem("prod456", "Джинсы", 4999, 1),
            CartItem("prod789", "Кроссовки", 5999, 1)
        )

        val request = RequestBasket(testUserId, gson.toJson(items), items.size)
        val response = api.postBasket(request)
        val basket = gson.fromJson(gson.toJson(response), BasketResponse::class.java)

        println("📦 Корзина ID: ${basket.id}")
        println("📦 Товары в корзине (${basket.items.size} шт.):")

        basket.items.forEachIndexed { index, item ->
            println("   ${index + 1}. ID: ${item.productId} - ${item.name} - ${item.price}₽ x${item.quantity}")
        }

        assertEquals(3, basket.items.size)
    }

    @Test
    fun testGetUserBaskets() = runBlocking {
        val productId = getProductId()

        // Создаем несколько корзин
        repeat(3) { i ->
            val items = listOf(CartItem(productId, "Товар $i", 1000 + i, 1))
            api.postBasket(RequestBasket(testUserId, gson.toJson(items), items.size))
        }

        // Получаем все корзины пользователя
        val response = api.getBaskets("-created")

        println("📊 Найдено корзин: ${response.totalItems}")
        println("📦 Корзины пользователя $testUserId:")

        val userBaskets = response.items.filter { it.user_id == testUserId }

        userBaskets.forEachIndexed { index, basket ->
            val basketData = gson.fromJson(gson.toJson(basket), BasketResponse::class.java)
            println("  ${index + 1}. Корзина: ${basketData.id}")
            println("     Товаров: ${basketData.count}")
            basketData.items.forEach { item ->
                println("       - ${item.name} (${item.productId})")
            }
        }

        assertTrue(userBaskets.size >= 3)
    }
}