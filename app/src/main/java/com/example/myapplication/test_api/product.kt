package com.example.myapplication.test_api

import com.example.myapplication.apiService
import com.example.myapplication.builder.fetch
import com.example.myapplication.models.Product
import com.example.myapplication.models.ProductDetailReq
import com.example.myapplication.models.ProductResponse
import retrofit2.Call

fun getProducts() {
    val partnerName = "uwg"
    val call: Call<ProductResponse> = apiService.getProducts(partnerName)

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
}

fun getProductDetails() {
    val name = ProductDetailReq("banana lemon")
    val call: Call<Product> = apiService.getProductByName(name)

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
}