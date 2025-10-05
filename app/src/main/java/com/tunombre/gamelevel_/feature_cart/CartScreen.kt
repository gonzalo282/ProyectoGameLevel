package com.tunombre.gamelevel_.feature_cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tunombre.gamelevel_.ui.composables.AppBottomBar
import com.tunombre.gamelevel_.ui.theme.GameLevel_Theme
import com.tunombre.gamelevel_.ui.theme.YellowAccent

/**
 * Composable principal que construye toda la pantalla del Carrito.
 * @param navController Controlador para manejar la navegación.
 * @param cartViewModel ViewModel que provee el estado para esta pantalla.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel = viewModel()
) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cart") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            AppBottomBar(navController = navController)
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        // Columna principal que contiene la lista y el resumen.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // La lista ocupa todo el espacio disponible.
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(top = 16.dp)
            ) {
                items(cartItems) { item ->
                    CartItemCard(item = item)
                }
            }

            // El resumen siempre se queda en la parte inferior.
            CartSummary()
        }
    }
}

/**
 * Composable para una sola tarjeta de item en el carrito.
 * @param item El objeto de datos del item a mostrar.
 */
@Composable
fun CartItemCard(item: CartItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center) {
                Text(text = "IMG", color = Color.Gray)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(item.title, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
                Text(item.price, color = YellowAccent, fontWeight = FontWeight.Bold)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { /* TODO */ }) { Text("-") }
                    Text(text = item.quantity.toString())
                    IconButton(onClick = { /* TODO */ }) { Text("+") }
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f))
                }
            }
        }
    }
}

/**
 * Composable para el resumen de la compra y el botón de checkout.
 */
@Composable
fun CartSummary() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Text("€25.19", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = YellowAccent)
            }
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = YellowAccent)
            ) {
                Text("Proceed to checkout", color = MaterialTheme.colorScheme.onSecondary, fontWeight = FontWeight.Bold)
            }
        }
    }
}

/**
 * Previsualización de la pantalla del Carrito en Android Studio.
 */
@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    GameLevel_Theme {
        val navController = NavController(androidx.compose.ui.platform.LocalContext.current)
        CartScreen(navController = navController)
    }
}