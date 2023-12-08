package com.example.myapplication

import com.example.myapplication.builder.RetrofitClient
import com.example.myapplication.test_api.resetPasswordUser
import com.example.myapplication.test_api.testGetUser
import com.example.myapplication.test_api.testLogin
import com.example.myapplication.test_api.testRegister
import com.example.myapplication.test_api.updateUser

// Introduce Route Publicly
public val apiService = RetrofitClient.retrofit.create(ApiRoutes::class.java)


fun main() {
    while (true) {
        println("API Tester GG Geming")
        println("1. Register")
        println("2. Login")
        println("3. Get User")
        println("4. Update User")

        val input = readln()
        when (input?.toIntOrNull()) {
            1 -> testRegister()
            2 -> testLogin()
            3 -> testGetUser()
            4 -> updateUser()
            5 -> resetPasswordUser()
        }
    }
}
