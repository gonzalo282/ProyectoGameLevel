package com.tunombre.gamelevel_.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// Componente reutilizable para la barra de navegación inferior
@Composable
fun AppBottomBar(navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        NavigationBarItem(
            selected = false, // La lógica de selección se puede añadir después
            onClick = { navController.navigate("catalog") },
            icon = { Icon(Icons.Default.Store, contentDescription = "Marketplace") },
            label = { Text("Marketplace") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* TODO: navController.navigate("search") */ },
            icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            label = { Text("Search") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("cart") },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("account") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Account") },
            label = { Text("Account") }
        )
    }
}