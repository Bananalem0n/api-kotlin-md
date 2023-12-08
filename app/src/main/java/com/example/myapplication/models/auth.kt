package com.example.myapplication.models


// Register
data class RegisterRequest (
    val email: String,
    val password: String,
    val firstname: String,
    val lastname: String,
)

data class RegisterResponse (
    val message: String,
    val data: RegisterResponseData
)

data class RegisterResponseData (
    val uuid: String,
    val name: String,
    val email: String,
    val role: String,
)


// Login
data class LoginRequest (
    val email: String,
    val password: String,
)

data class LoginResponse (
    val data: LoginResponseData,
    val sessionCookie: String,
)

data class LoginResponseData(
    val idToken: String,
    val uid: String,
    val businessName: String,
    val email: String,
    val role: String
)