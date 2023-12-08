package com.example.myapplication.test_api

import com.example.myapplication.apiService
import com.example.myapplication.builder.fetch
import com.example.myapplication.models.GetUserResponse
import com.example.myapplication.models.ResetUserRequest
import com.example.myapplication.models.UpdateUserResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import java.io.File


fun testGetUser() {
    val payload = "gugugu@gmail.com"
    val call: Call<GetUserResponse> = apiService.getUserData(payload)

    fetch(call,
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

fun updateUser() {
    val uid = "3uckGesT74cxVyAjTb9n3uAOvhG3".toRequestBody("text/plain".toMediaTypeOrNull())
    val email = "gugugu@gmail.com".toRequestBody("text/plain".toMediaTypeOrNull())
    val displayName = "John Doe".toRequestBody("text/plain".toMediaTypeOrNull())
    val phoneNumber = "+6281213224060".toRequestBody("text/plain".toMediaTypeOrNull())

    // image handling (change the path)
    val imageFile = File("/home/bananalemon/Downloads/","image-removebg-preview.png")
    val image = imageFile.asRequestBody("image/*".toMediaTypeOrNull())

    val imagePart = MultipartBody.Part.createFormData("image", imageFile.name, image)

    val call: Call<UpdateUserResponse> = apiService.updateUserData(uid, email, displayName, imagePart, phoneNumber)

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

fun resetPasswordUser() {
    try {
        val email = ResetUserRequest("bananalemon021103@gmail.com")
        println(email)

        val call: Call<Unit> = apiService.resetUserData(email)
        val response = call.execute()

        if (response.isSuccessful) {
            // Handle successful response (HTTP 2xx status)
            println("Reset password successful")
        } else {
            // Handle error response (non-2xx status)
            println("Reset password failed with code: ${response.code()}")
        }
    } catch (error: Throwable) {
        // Handle other exceptions
        println("An error occurred: ${error.message}")
    } finally {
        println("Operation completed")
    }
}