package com.example.budgetandfinanceingapplication.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("test")
    fun testConnection(): Call<String>
}
