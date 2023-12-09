package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class PartnerData(
    @SerializedName("displayName")
    val displayName: String,

    @SerializedName("businessName")
    val businessName: String,

    val logo: String,

    val telephone: String,

    val uuid: String,

    val email: String,

    val timestamp: String,

    @SerializedName("lastUpdate")
    val lastUpdate: String,

    @SerializedName("olshopUrl")
    val olshopUrl: String,

    val deskripsi: String,

    val nib: String
)
