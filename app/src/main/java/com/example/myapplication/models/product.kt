package com.example.myapplication.models

import com.google.gson.annotations.SerializedName


data class ProductResponse(
    @SerializedName("productCollection")
    val productCollection: List<ProductItem>
)

data class ProductDetailReq (
    val name: String
)