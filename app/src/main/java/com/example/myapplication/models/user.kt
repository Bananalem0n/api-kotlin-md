package com.example.myapplication.models

import java.nio.Buffer


// Get User Data
data class GetUserResponse (
    val uid: String,
    val email: String,
    val displayName: String,
    val photoUrl: String,
    val phoneNumber: String,
)

// Update UserData

data class UpdateUserRequest (
    val uid: String,
    val email: String,
    val displayName: String,
    val image: Buffer,
    val phoneNumber: String,
)

data class UpdateUserResponse (
    val message: String,
)

data class ResetUserRequest (
    val email: String,
)
