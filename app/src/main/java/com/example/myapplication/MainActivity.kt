package com.example.myapplication

import com.example.myapplication.builder.RetrofitClient
import com.example.myapplication.test_api.getHomepage
import com.example.myapplication.test_api.getPartnerData
import com.example.myapplication.test_api.getProductDetails
import com.example.myapplication.test_api.getProductQr
import com.example.myapplication.test_api.getProducts
import com.example.myapplication.test_api.resetPasswordUser
import com.example.myapplication.test_api.reviewProduct
import com.example.myapplication.test_api.testGetUser
import com.example.myapplication.test_api.testLogin
import com.example.myapplication.test_api.testRegister
import com.example.myapplication.test_api.updateUser

// Introduce Route Publicly
val apiService: ApiRoutes = RetrofitClient.retrofit.create(ApiRoutes::class.java)


fun main() {
    while (true) {
        println("API Tester GG")
        println("0. Register")
        println("1. Login")
        println("2. Get User")
        println("3. Update User")
        println("4. Reset Password")
        println("5. Get Homepage")
        println("6. Get Partner")
        println("7. Get All Product within Partner")
        println("8. Get Data for Specific Product")
        println("9. Get Product Data with Qr Scan")


        val input = readln()
        when (input.toIntOrNull()) {
            0 -> testRegister()
            1 -> testLogin()
            2 -> testGetUser()
            3 -> updateUser()
            4 -> resetPasswordUser()
            5 -> getHomepage()
            6 -> getPartnerData()
            7 -> getProducts()
            8 -> getProductDetails()
            9 -> getProductQr()
            10 -> reviewProduct()
        }
    }
}
