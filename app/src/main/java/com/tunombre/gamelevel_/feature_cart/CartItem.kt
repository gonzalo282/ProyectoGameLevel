package com.tunombre.gamelevel_.feature_cart

// Modelo de datos para un item en el carrito
data class CartItem(
    val id: Int,
    val title: String,
    val price: String,
    val imageUrl: String,
    var quantity: Int
)