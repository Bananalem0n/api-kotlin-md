package com.example.myapplication.test_api

import com.example.myapplication.apiService
import com.example.myapplication.builder.fetch
import com.example.myapplication.models.PartnerData
import retrofit2.Call

fun getPartnerData() {
    val call: Call<PartnerData> = apiService.getPartner()
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