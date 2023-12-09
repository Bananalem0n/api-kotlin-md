package com.example.myapplication.models

data class Review (
    val uid: String,
    val productRef: String,
    val partnerRef: String,
    val name: String,
    val email: String,
    val timestamp: String,
    val rating: Int,
    val review: String
)

data class ReviewResponse (
    val message: String
)