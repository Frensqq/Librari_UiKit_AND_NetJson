package com.example.networklibrary.Domain.reposytory

import com.example.networklibrary.Domain.model.Basket
import com.example.networklibrary.Domain.model.NetworkResult
import com.example.networklibrary.Domain.model.Order
import com.example.networklibrary.Domain.model.Product
import com.example.networklibrary.Domain.model.Project
import com.example.networklibrary.Domain.model.RequestAuth
import com.example.networklibrary.Domain.model.RequestBasket
import com.example.networklibrary.Domain.model.RequestBasketUpdate
import com.example.networklibrary.Domain.model.RequestOrder
import com.example.networklibrary.Domain.model.RequestProject
import com.example.networklibrary.Domain.model.RequestRegister
import com.example.networklibrary.Domain.model.RequestUserUpdate
import com.example.networklibrary.Domain.model.ResponseAuth
import com.example.networklibrary.Domain.model.ResponseBasket
import com.example.networklibrary.Domain.model.ResponseNews
import com.example.networklibrary.Domain.model.ResponseOrders
import com.example.networklibrary.Domain.model.ResponseProducts
import com.example.networklibrary.Domain.model.ResponseProjects
import com.example.networklibrary.Domain.model.ResponseRegister
import com.example.networklibrary.Domain.model.User


interface Repository {

    suspend fun Register(request: RequestRegister): NetworkResult<ResponseRegister>

    suspend fun Auth(request: RequestAuth): NetworkResult<ResponseAuth>

    suspend  fun getUser(userId: String ): NetworkResult<User>

    suspend fun pathUser( userId: String, request: RequestUserUpdate ): NetworkResult<User>

    //

    suspend fun getProducts(filter: String,
                     page: Int,
                     perPage: Int ,
                   sort: String
    ): NetworkResult<ResponseProducts>


    suspend fun getProduct(productId: String): NetworkResult<Product>


    suspend fun getNews(page: Int,
                 perPage: Int ,
    ): NetworkResult<ResponseNews>


    suspend fun getProjects( page: Int,
                    perPage: Int ,
                   sort: String
    ): NetworkResult<ResponseProjects>

    suspend fun postProject(request: RequestProject): NetworkResult<Project>

    suspend  fun getProject(projectId : String): NetworkResult<Project>

    suspend fun getBaskets(): NetworkResult<ResponseBasket>

    suspend fun postBasket( request: RequestBasket): NetworkResult<Basket>

    suspend  fun getBasket(basketId: String): NetworkResult<Basket>

    suspend  fun patchBasket(basketId: String, request: RequestBasketUpdate): NetworkResult<Basket>

    suspend fun deleteBasket( basketId: String): NetworkResult<Unit>

    suspend  fun getOrders(page: Int,
                   perPage: Int ,
                   sort: String)
            : NetworkResult<ResponseOrders>


    suspend  fun postOrder(request: RequestOrder): NetworkResult<Order>

    suspend fun getOrder( orderId : String): NetworkResult<Order>


}