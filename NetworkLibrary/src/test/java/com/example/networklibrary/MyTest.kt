package com.example.networklibrary

import com.example.networklibrary.Data.remote.PBApi
import com.example.networklibrary.Data.remote.PBApiServis
import com.example.networklibrary.Domain.model.RequestAuth
import com.example.networklibrary.Domain.model.RequestBasket
import com.example.networklibrary.Domain.model.RequestRegister
import com.example.networklibrary.Domain.model.ResponseBasket
import com.example.networklibrary.Domain.model.ResponseOrders
import com.example.networklibrary.Domain.model.ResponseProducts
import com.example.networklibrary.Domain.model.ResponseProjects
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MyTest{

    private lateinit var api: PBApi

    private var UserId = ""

    private var email = "email06${System.currentTimeMillis()}@profy.ru"
    private var identity = ""

    private var Products: ResponseProducts? = null

    val gson = Gson()




    @Before
    fun Setup(){

        api = PBApiServis.instance
        identity = email
        UserId = Register(email).id
        Auth()
        Products = getProduct()
    }


    fun Register(email: String) = runBlocking{
        api.Register(RequestRegister(
            email,
            "11111111",
            "11111111"
        ))
    }

    fun getProduct() = runBlocking{
        api.getProducts(
            "id != 'null'",
            1,
            30,
            "+created"
        )
    }

    fun Auth() = runBlocking{
        val response = api.Auth(RequestAuth(
            identity = identity,
            "11111111",
        ))
        PBApiServis.setAuthToken(response.token)
    }

    @Test
    fun RegisteUser(){
        Register("email06test${System.currentTimeMillis()}@profy.ru")
    }

    @Test
    fun AuthTest(){
        Auth()
    }

    @Test
    fun NewsTest(){
        runBlocking {
            val rez = api.getNews(1, 30)
            println(rez.totalItems)
        }
    }

    @Test
    fun AddToCard(){

        val items = listOf(
            CartItem(Products?.items[0]?.id?:"Unknown",
                Products?.items[0]?.title?:"Unknown",
                Products?.items[0]?.price?:0,
                2
            ),
                    CartItem(Products?.items[0]?.id?:"Unknown",
            Products?.items[0]?.title?:"Unknown",
            Products?.items[0]?.price?:0,
            2
        ),
        CartItem(Products?.items[0]?.id?:"Unknown",
            Products?.items[0]?.title?:"Unknown",
            Products?.items[0]?.price?:0,
            2
        ),
        CartItem(Products?.items[0]?.id?:"Unknown",
            Products?.items[0]?.title?:"Unknown",
            Products?.items[0]?.price?:0,
            2
        )
        )
        println(Products?.items)

        runBlocking {

            val rez = api.postBasket(
                RequestBasket(
                    UserId,
                    items = gson.toJson(items),
                    count = 0
                )
            )

            val response = api.getBaskets()

            println("📊 Всего корзин: ${response.totalItems}")
            println("📦 Список корзин пользователя $UserId:")

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

        }
    }




    @Test
    fun ViewProject(){

        runBlocking {
            val rez = api.getProducts(
                "id != 'null'",
                1,
                30,
                "+created"
                )

            println(rez.items)
        }
    }


}