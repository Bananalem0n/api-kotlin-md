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


// Constants
val TEXT_PLAIN_MEDIA_TYPE = "text/plain".toMediaTypeOrNull()
val IMAGE_MEDIA_TYPE = "image/*".toMediaTypeOrNull()

// Function to handle image file
fun createImagePart(filePath: String): MultipartBody.Part {
    val imageFile = File(filePath)
    val image = imageFile.asRequestBody(IMAGE_MEDIA_TYPE)
    return MultipartBody.Part.createFormData("image", imageFile.name, image)
}

fun testGetUser() {
    val email = "gugugu@gmail.com"
    val call: Call<GetUserResponse> = apiService.getUserData(email)

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

fun updateUser() {
    val uid = "3uckGesT74cxVyAjTb9n3uAOvhG3".toRequestBody(TEXT_PLAIN_MEDIA_TYPE)
    val email = "gugugu@gmail.com".toRequestBody(TEXT_PLAIN_MEDIA_TYPE)
    val displayName = "John Doe".toRequestBody(TEXT_PLAIN_MEDIA_TYPE)
    val phoneNumber = "+6281213224060".toRequestBody(TEXT_PLAIN_MEDIA_TYPE)

    val imagePart = createImagePart("/home/bananalemon/Downloads/image-removebg-preview.png")

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