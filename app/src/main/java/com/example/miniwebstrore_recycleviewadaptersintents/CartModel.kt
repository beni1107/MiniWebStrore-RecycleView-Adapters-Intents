package com.example.miniwebstrore_recycleviewadaptersintents

data class CartModel(
    val cartItem_Image :Int,
    val cartItem_Name : String,
    val cartItem_Price : String,
    var quantity: Int = 1
)
