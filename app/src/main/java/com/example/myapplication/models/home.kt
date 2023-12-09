package com.example.myapplication.models

import com.google.gson.annotations.SerializedName


data class HomeResponseData(
    @SerializedName("productCollection")
    val productCollection: List<ProductItem>,

    @SerializedName("partnerCollection")
    val partnerCollection: List<PartnerItem>
)

data class ProductItem(
    val product: Product
)

data class Product(
    val images: List<String>,
    val harga: Int,
    val material: String,
    val name: String,
    val kategori: String?,
    val packaging: String,
    val deskripsi: String,
    val stock: Int,
    val proses: String,
    val tags: List<String>?,
    @SerializedName("qrcodeURL")
    val qrCodeUrl: String
)

data class PartnerItem(
    val id: String,
    @SerializedName("displayName")
    val partnerDisplayName: String,
    val nib: String,
    @SerializedName("businessName")
    val partnerBusinessName: String,
    val logo: String,
    val telephone: String,
    val deskripsi: String,
    val uuid: String,
    val email: String,
    val timestamp: String
)
