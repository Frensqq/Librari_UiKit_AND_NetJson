package com.example.networklibrary.Domain.model

sealed class NetworkResult<out T>{
    data class Success<T>(val data: T): NetworkResult<T>()
    data class Error(val error400: Error400): NetworkResult<Nothing>()
    object NoInternet:  NetworkResult<Nothing>()
}