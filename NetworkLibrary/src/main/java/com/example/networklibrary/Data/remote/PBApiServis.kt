package com.example.networklibrary.Data.remote

import androidx.compose.ui.graphics.GraphicsLayerScope
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PBApiServis {
    private const val BASE_URL = "http://127.0.0.1:8090/api/"
    private var authToken: String? = null

    fun setAuthToken(token: String) {
        authToken = token
    }

    val instance: PBApi by lazy {

        val client = OkHttpClient
            .Builder().addInterceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().apply {
                        authToken?.let { addHeader("Authorization", "Bearer ${it}") }
                    }.build()
                )
            }.build()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PBApi::class.java)
    }

    fun createImgUrl(collection: String, record: String, image: String): String {
        return "${BASE_URL}files/$collection/$record/$image"
    }
}