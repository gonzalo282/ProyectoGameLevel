package com.tunombre.gamelevel_.feature_home

// Importamos lo necesario de Jetpack Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tunombre.gamelevel_.R
import com.tunombre.gamelevel_.ui.theme.GameLevel_Theme

// Pantalla principal de login
@Composable
fun HomeScreen() {
    // Scaffold es el contenedor base, maneja barras, floating buttons, etc.
    Scaffold { inner ->
        // Columna principal que ordena los elementos de arriba a abajo
        Column(
            modifier = Modifier
                .fillMaxSize()        // Ocupa toda la pantalla
                .padding(inner),      // Respeta los paddings del Scaffold
            horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
        ) {
            // Logo en la parte superior (usa drawable/logo.png)
            Image(
                painter = painterResource(id = R.drawable.logo), // Imagen desde carpeta res/drawable
                contentDescription = "Logo de la app", // Accesibilidad
                modifier = Modifier
                    .fillMaxWidth()   // Imagen ocupa ancho completo
                    .height(220.dp),  // Altura fija de 220dp
                contentScale = ContentScale.Fit // Ajuste proporcional
            )

            Spacer(Modifier.height(50.dp)) // Espacio debajo de la imagen

            // Título y subtítulo (centrados)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Game Level", // Título principal
                    style = MaterialTheme.typography.headlineSmall, // Estilo de Material 3
                    fontWeight = FontWeight.SemiBold, // Negrita media
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Inicia sesión o regístrate para continuar", // Subtítulo
                    style = MaterialTheme.typography.bodyMedium, // Texto secundario
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(24.dp)) // Espacio antes de los botones

            // Columna con botones de inicio de sesión
            Column(
                Modifier
                    .fillMaxWidth()            // Ancho completo
                    .padding(horizontal = 16.dp), // Márgenes laterales
                verticalArrangement = Arrangement.spacedBy(12.dp) // Espaciado entre botones
            ) {
                // Botón principal: Iniciar sesión con correo
                Button(
                    onClick = { /* TODO: login con correo */ }, // Aquí va la lógica
                    modifier = Modifier.fillMaxWidth(),         // Botón ocupa todo el ancho
                    shape = RoundedCornerShape(14.dp),          // Bordes redondeados
                    contentPadding = PaddingValues(vertical = 14.dp, horizontal = 16.dp) // Relleno interno
                ) {
                    Icon(Icons.Filled.Email, contentDescription = "Correo") // Ícono a la izquierda
                    Spacer(Modifier.width(8.dp)) // Espacio entre ícono y texto
                    Text("Iniciar sesión con correo")
                }

                // Botón secundario: Iniciar sesión con password
                OutlinedButton( // Diferente estilo (solo borde)
                    onClick = { /* TODO: login con password */ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    contentPadding = PaddingValues(vertical = 14.dp, horizontal = 16.dp)
                ) {
                    Icon(Icons.Filled.Lock, contentDescription = "Password")
                    Spacer(Modifier.width(8.dp))
                    Text("Iniciar sesión con password")
                }
            }

            Spacer(Modifier.height(30.dp)) // Espacio antes del separador

            // Texto separador con líneas a los lados
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp), // Márgenes laterales
                verticalAlignment = Alignment.CenterVertically
            ) {
                (Modifier.weight(1f)) // Línea izquierda
                Text(
                    "  o regístrate con  ", // Texto centrado
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
                (Modifier.weight(1f)) // Línea derecha
            }

            // Spacer flexible que empuja los íconos hacia abajo
            Spacer(modifier = Modifier.weight(1f))

            // Botones redondos para login social (Google, Facebook, Apple)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 32.dp), // Espaciado adicional
                horizontalArrangement = Arrangement.SpaceEvenly, // Distribuye igual el espacio
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedButton(
                    onClick = { /* TODO: Google */ },
                    shape = CircleShape, // Forma circular
                    contentPadding = PaddingValues(20.dp) // Tamaño del círculo
                ) {
                    Icon(Icons.Filled.Public, contentDescription = "Google")
                }
                ElevatedButton(
                    onClick = { /* TODO: Facebook */ },
                    shape = CircleShape,
                    contentPadding = PaddingValues(20.dp)
                ) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Facebook")
                }
                ElevatedButton(
                    onClick = { /* TODO: Apple */ },
                    shape = CircleShape,
                    contentPadding = PaddingValues(20.dp)
                ) {
                    Icon(Icons.Filled.Android, contentDescription = "Apple")
                }
            }
        }
    }
}

// Preview para ver cómo se ve en Android Studio
@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    GameLevel_Theme { HomeScreen() }
}
