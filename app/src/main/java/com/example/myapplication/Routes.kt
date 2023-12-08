package com.example.myapplication

import android.view.PixelCopy.Request
import com.example.myapplication.models.GetUserResponse
import com.example.myapplication.models.LoginRequest
import com.example.myapplication.models.LoginResponse
import com.example.myapplication.models.RegisterRequest
import com.example.myapplication.models.RegisterResponse
import com.example.myapplication.models.ResetUserRequest
import com.example.myapplication.models.UpdateUserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiRoutes {
//    AUTH ROUTER
    @POST("auth/register")
    fun register(@Body payload: RegisterRequest): Call<RegisterResponse>

    @POST("auth/login")
    fun login(@Body payload: LoginRequest): Call<LoginResponse>

//    USER ROUTER
    @GET("user")
    fun getUserData(@Query("email") email: String): Call<GetUserResponse>

    @Multipart
    @POST("user/edit")
    fun updateUserData(
        @Part("uid") uid: RequestBody,
        @Part("email") email: RequestBody,
        @Part("displayName") displayName: RequestBody,
        @Part image: MultipartBody.Part,
        @Part("phoneNumber") phoneNumber: RequestBody,
    ): Call<UpdateUserResponse>

    @POST("user/reset")
    fun resetUserData(@Body email: ResetUserRequest): Call<Unit>
}