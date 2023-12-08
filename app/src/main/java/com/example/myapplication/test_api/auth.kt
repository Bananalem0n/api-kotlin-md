package com.example.myapplication.test_api

import com.example.myapplication.ApiRoutes
import com.example.myapplication.apiService
import com.example.myapplication.builder.RetrofitClient
import com.example.myapplication.builder.fetch
import com.example.myapplication.models.LoginRequest
import com.example.myapplication.models.LoginResponse
import com.example.myapplication.models.RegisterRequest
import com.example.myapplication.models.RegisterResponse
import retrofit2.Call

fun testRegister() {
    val payload: RegisterRequest = RegisterRequest(
        "ikramboboboi@bangkit.com",
        "ikrams123",
        "muhammad",
        "ikrams"
    )
    val call: Call<RegisterResponse> = apiService.register(payload)

    fetch(call,
        success = { response ->
            // Handle successful response
            println(response)
        },
        error = { code, message ->
            // Handle error
            println("Login failed. Error: $code - $message")
        }
    )
}

fun testLogin() {
    val payload: LoginRequest = LoginRequest("gugugu@gmail.com", "ukasyah")
    val call: Call<LoginResponse> = apiService.login(payload)

    fetch(call,
        success = { response ->
            // Handle successful response
            println(response)
        },
        error = { code, message ->
            // Handle error
            println("Login failed. Error: $code - $message")
        }
    )
}