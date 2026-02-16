package com.example.networklibrary.Data.reposytory

import android.content.Context
import com.example.networklibrary.Data.remote.PBApi
import com.example.networklibrary.Domain.model.Basket
import com.example.networklibrary.Domain.model.Error400
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
import com.example.networklibrary.Domain.reposytory.Repository
import com.example.networklibrary.Network.NetworkMonitor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class ReposytoruImpl(private val api: PBApi, private val context: Context, private val networkMonitor: NetworkMonitor): Repository {


    private suspend fun<T> safeApiCall(apiCall: suspend() -> T): NetworkResult<T> {
        if (!networkMonitor.isConnected()) {
            return NetworkResult.NoInternet
        }
        return try {
            NetworkResult.Success(apiCall())
        } catch (e: IOException) {
            NetworkResult.NoInternet
        } catch (e: HttpException) {
            NetworkResult.Error(
                Error400(
                    e.code(),
                    e.message.toString(),
                    mapOf("raw" to (e.response()?.errorBody()?.string()?:"Unknown"))
                )
            )
        }catch (e: Exception) {
            NetworkResult.Error(
                Error400(
                    -1,
                    e.message.toString()
                )
            )
        }

    }

    override suspend fun Auth(request: RequestAuth): NetworkResult<ResponseAuth> =safeApiCall{
        api.Auth(request)
    }

    override suspend fun Register(request: RequestRegister): NetworkResult<ResponseRegister> =safeApiCall{
        api.Register(request)
    }

    override suspend fun deleteBasket(basketId: String): NetworkResult<Unit> =safeApiCall{
        api.deleteBasket(basketId)
    }

    override suspend fun getBasket(basketId: String): NetworkResult<Basket> =safeApiCall{
        api.getBasket(basketId)
    }

    override suspend fun getBaskets(): NetworkResult<ResponseBasket> =safeApiCall{
        api.getBaskets()
    }

    override suspend fun getNews(page: Int, perPage: Int): NetworkResult<ResponseNews> =safeApiCall{
        api.getNews(page,perPage)
    }

    override suspend fun getOrder(orderId: String): NetworkResult<Order> =safeApiCall{
        api.getOrder(orderId)
    }

    override suspend fun getOrders(
        page: Int,
        perPage: Int,
        sort: String
    ): NetworkResult<ResponseOrders> =safeApiCall{
        api.getOrders(page,perPage,sort)
    }

    override suspend fun getProduct(productId: String): NetworkResult<Product> =safeApiCall{
        api.getProduct(productId)
    }

    override suspend fun getProducts(
        filter: String,
        page: Int,
        perPage: Int,
        sort: String
    ): NetworkResult<ResponseProducts> =safeApiCall{
        api.getProducts(filter,page,perPage,sort)
    }

    override suspend fun getProject(projectId: String): NetworkResult<Project> =safeApiCall{
       api.getProject(projectId)
    }

    override suspend fun getProjects(
        page: Int,
        perPage: Int,
        sort: String
    ): NetworkResult<ResponseProjects> =safeApiCall{
        api.getProjects(page,perPage,sort)
    }

    override suspend fun getUser(userId: String): NetworkResult<User> =safeApiCall{
       api.getUser(userId)
    }

    override suspend fun patchBasket(
        basketId: String,
        request: RequestBasketUpdate
    ): NetworkResult<Basket> =safeApiCall{
        api.patchBasket(basketId,request)
    }

    override suspend fun pathUser(userId: String, request: RequestUserUpdate): NetworkResult<User> =safeApiCall{
        api.pathUser(userId,request)
    }

    override suspend fun postBasket(request: RequestBasket): NetworkResult<Basket> =safeApiCall{
        api.postBasket(request)
    }

    override suspend fun postOrder(request: RequestOrder): NetworkResult<Order> =safeApiCall{
        api.postOrder(request)
    }

    override suspend fun postProject(request: RequestProject): NetworkResult<Project> =safeApiCall{

        val filelds = mutableMapOf<String, RequestBody>().apply{
            this["size"] = request.size.toRequestBody("image/plane".toMediaType())
            this["description_source"] = request.description_source.toRequestBody("image/plane".toMediaType())
            this["date_end"] = request.date_end.toRequestBody("image/plane".toMediaType())
            this["date_start"] = request.date_start.toRequestBody("image/plane".toMediaType())
            this["user_id"] = request.user_id.toRequestBody("image/plane".toMediaType())
            this["type"] = request.type.toRequestBody("image/plane".toMediaType())
            this["title"] = request.title.toRequestBody("image/plane".toMediaType())
        }

        val imagePart = request.technical_drawing?.let { uri ->
            val file = File.createTempFile("image_", ".jpg", context.cacheDir)
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                file.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
            val requestBody = file.asRequestBody("image/*".toMediaType())
            MultipartBody.Part.createFormData("image", file.name, requestBody)

        }

        api.postProject(filelds, imagePart)
    }
}