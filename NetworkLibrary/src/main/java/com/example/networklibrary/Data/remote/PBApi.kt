package com.example.networklibrary.Data.remote

import com.example.networklibrary.Domain.model.Basket
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
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query

interface PBApi {

    //User
    @POST("collections/users/records")
    suspend  fun Register(@Body request: RequestRegister): ResponseRegister

    @POST("collections/users/auth-with-password")
    suspend fun Auth(@Body request: RequestAuth): ResponseAuth

    @GET("collections/users/records/{userId}")
    suspend fun getUser(@Path("userId") userId: String ): User

    @PATCH("collections/users/records/{userId}")
    suspend fun pathUser(@Path("userId") userId: String, @Body request: RequestUserUpdate ): User

    //
    @GET("collections/products/records")
    suspend fun getProducts(@Query("filter") filter: String,
                   @Query("page") page: Int,
                   @Query("perPage") perPage: Int ,
                   @Query("sort") sort: String
    ): ResponseProducts

    @GET("collections/products/records/{productId}")
    suspend fun getProduct(@Part("productId") productId: String): Product

    @GET("collections/promotions_and_news/records")
    suspend fun getNews(@Query("page") page: Int,
                   @Query("perPage") perPage: Int ,
    ): ResponseNews


    @GET("collections/projects/records")
    suspend fun getProjects(@Query("page") page: Int,
                    @Query("perPage") perPage: Int ,
                    @Query("sort") sort: String
    ): ResponseProjects

    @Multipart
    @POST("collections/projects/records")
    suspend fun postProject(
        @PartMap request: Map<String, @JvmSuppressWildcards RequestBody>,
        @Part image: MultipartBody.Part? = null
        ): Project

    @GET("collections/projects/records/{projectId}")
    suspend fun getProject(@Path("projectId") projectId : String): Project


    @GET("collections/basket/records")
    suspend fun getBaskets(): ResponseBasket

    @POST("collections/basket/records")
    suspend fun postBasket(@Body request: RequestBasket): Basket

    @GET("collections/basket/records/{basketId}")
    suspend fun getBasket(@Path("basketId") basketId: String): Basket

    @PATCH("collections/basket/records/{basketId}")
    suspend  fun patchBasket(@Path("basketId") basketId: String, @Body request: RequestBasketUpdate): Basket

    @DELETE("collections/basket/records/{basketId}")
    suspend fun deleteBasket(@Path("basketId") basketId: String): Unit


    @GET("collections/orders/records")
    suspend fun getOrders(@Query("page") page: Int,
                   @Query("perPage") perPage: Int ,
                   @Query("sort") sort: String)
    : ResponseOrders

    @POST("collections/orders/records")
    suspend fun postOrder(@Body request: RequestOrder): Order

    @GET("collections/basket/records/{orderId}")
    suspend fun getOrder(@Path("orderId") orderId : String): Order

}