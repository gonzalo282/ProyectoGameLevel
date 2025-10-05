package com.tunombre.gamelevel_.feature_cart

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel que maneja la lógica de la pantalla del carrito
class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        _cartItems.value = listOf(
            CartItem(3, "Xbox Game Pass Ultimate", "€9.98", "", 1),
            CartItem(5, "Minecraft: Java & Bedrock Edition", "€15.21", "", 1)
        )
    }
}