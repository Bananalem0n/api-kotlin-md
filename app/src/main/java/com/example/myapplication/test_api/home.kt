package com.example.myapplication.test_api

import com.example.myapplication.apiService
import com.example.myapplication.builder.fetch
import com.example.myapplication.models.HomeResponseData
import retrofit2.Call

fun getHomepage() {
    try {
        val call: Call<HomeResponseData> = apiService.getHome()

        fetch(
            call,
            success = { response ->
                // Handle successful response
                println(response)
            },
            error = { code, message ->
                // Handle error
                println("Request failed. Error: $code - $message")
            }
        )
    } catch (error: Throwable) {
        // Handle other exceptions
        println("An error occurred: ${error.message}")
    }
}