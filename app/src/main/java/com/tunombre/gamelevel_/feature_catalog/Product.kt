package com.tunombre.gamelevel_.feature_catalog

// Modelo de datos para un producto
data class Product(
    val id: Int,
    val title: String,
    val platform: String,
    val price: String,
    val imageUrl: String
)