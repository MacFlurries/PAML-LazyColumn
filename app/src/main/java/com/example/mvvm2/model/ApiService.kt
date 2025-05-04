package com.example.mvvm2.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}