package com.example.myapplication

import com.example.myapplication.builder.RetrofitClient
import com.example.myapplication.test_api.getHomepage
import com.example.myapplication.test_api.getPartnerData
import com.example.myapplication.test_api.getProducts
import com.example.myapplication.test_api.resetPasswordUser
import com.example.myapplication.test_api.testGetUser
import com.example.myapplication.test_api.testLogin
import com.example.myapplication.test_api.testRegister
import com.example.myapplication.test_api.updateUser

// Introduce Route Publicly
val apiService: ApiRoutes = RetrofitClient.retrofit.create(ApiRoutes::class.java)


fun main() {
    while (true) {
        println("API Tester GG")
        println("1. Register")
        println("2. Login")
        println("3. Get User")
        println("4. Update User")
        println("5. Reset Password")
        println("6. Get Homepage")
        println("7. Get Partner")
        println("8. Get All Product within Partner")
        println("9. Get Data for Specific Product")

        val input = readln()
        when (input.toIntOrNull()) {
            1 -> testRegister()
            2 -> testLogin()
            3 -> testGetUser()
            4 -> updateUser()
            5 -> resetPasswordUser()
            6 -> getHomepage()
            7 -> getPartnerData()
            8 -> getProducts()
//            9 ->
        }
    }
}
