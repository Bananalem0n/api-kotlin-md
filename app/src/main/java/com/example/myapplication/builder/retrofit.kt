package com.example.myapplication.builder

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// RetroFitBuilder
object RetrofitClient {
    private const val BASE_URL = "https://backend-service-fmgaz4qprq-as.a.run.app/api/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

// Fetch API Endpoints
fun <T> fetch(call: Call<T>, success: (T?) -> Unit, error: (Int, String) -> Unit) {
    try {
        val response: Response<T> = call.execute()
        if (response.isSuccessful) {
            success(response.body())
        } else {
            error(response.code(), response.message())
        }
    } catch (e: Exception) {
        // Handle other exceptions if needed
        println("Exception occurred: ${e.message}")
    }
}