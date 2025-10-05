package com.tunombre.gamelevel_.feature_catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
 * Composable principal que construye toda la pantalla del catálogo.
 * @param navController Controlador para manejar la navegación entre pantallas.
 * @param catalogViewModel ViewModel que provee el estado y la lógica para esta pantalla.
 */
@Composable
fun CatalogScreen(
    navController: NavController,
    catalogViewModel: CatalogViewModel = viewModel()
) {
    // Observamos la lista de productos del ViewModel. Cada vez que cambie, la UI se recompondrá.
    val products by catalogViewModel.products.collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            // Usamos el componente compartido para la barra de navegación inferior.
            AppBottomBar(navController = navController)
        }
    ) { paddingValues ->
        // LazyColumn es el equivalente de RecyclerView para mostrar listas verticales de forma eficiente.
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp) // Espacio entre cada item de la lista.
        ) {
            // Primer item: la barra de búsqueda y el título.
            item {
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Search...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Top games", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Siguientes items: creamos un ProductCard por cada producto en la lista.
            items(products) { product ->
                ProductCard(product = product)
            }
        }
    }
}

/**
 * Composable que define la apariencia de una sola tarjeta de producto.
 * @param product El objeto de datos del producto a mostrar.
 */
@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder para la imagen del producto.
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                // En un proyecto real, aquí usarías una librería como Coil para cargar la imagen:
                // AsyncImage(model = product.imageUrl, contentDescription = product.title)
                Text(text = "IMG", color = Color.Gray)
            }

            // Columna con los textos (título, plataforma, precio).
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = product.platform,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = product.price,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = YellowAccent
                )
            }

            // Columna con los botones de acción (favorito, agregar al carrito).
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = { /* TODO: Lógica de favoritos */ }) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite", tint = MaterialTheme.colorScheme.onSurface)
                }
                Button(
                    onClick = { /* TODO: Lógica de agregar al carrito */ },
                    colors = ButtonDefaults.buttonColors(containerColor = YellowAccent)
                ) {
                    Icon(Icons.Default.ShoppingCart, contentDescription = "Add to cart", tint = MaterialTheme.colorScheme.onSecondary)
                }
            }
        }
    }
}

/**
 * Previsualización de la pantalla del Catálogo en Android Studio.
 */
@Preview(showBackground = true)
@Composable
fun CatalogScreenPreview() {
    GameLevel_Theme {
        // Creamos un NavController falso para la previsualización.
        val navController = NavController(androidx.compose.ui.platform.LocalContext.current)
        CatalogScreen(navController = navController)
    }
}