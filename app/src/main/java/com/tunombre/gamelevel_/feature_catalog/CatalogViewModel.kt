package com.tunombre.gamelevel_.feature_catalog

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel que maneja la lógica y el estado de la pantalla de catálogo
class CatalogViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        // En el futuro, estos datos vendrían de una API
        _products.value = listOf(
            Product(1, "Detroit: Become Human Key", "STEAM", "€8.21", ""),
            Product(2, "Bomb Rush Cyberfunk (PC) Key", "GLOBAL", "€3.58", ""),
            Product(3, "Xbox Game Pass Ultimate", "XBOX LIVE", "€9.98", ""),
            Product(4, "Call of Duty: Black Ops 7", "OTHER", "€0.23", "")
        )
    }
}