package com.example.myapplication.test_api

import com.example.myapplication.apiService
import com.example.myapplication.builder.fetch
import com.example.myapplication.models.Product
import com.example.myapplication.models.Review
import com.example.myapplication.models.ReviewResponse
import retrofit2.Call

fun getProductQr() {
    val ref = "/verifiedPartner/uwg/products/Greenbean Coffe"
    val call: Call<Product> = apiService.getProductDataFromQR(ref)

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

fun reviewProduct() {
    val data = Review(
        "kB25SC1cjP",
        "verifiedPartner/uwg/products/malgarine",
        "verifiedPartner/uwg",
        "joe",
        "joemama@gmail.com",
        "2023-11-23T17:43:28.449Z",
        4,
        "produk bagus"
    )
    val call: Call<ReviewResponse> = apiService.postReviewProduct(data)
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