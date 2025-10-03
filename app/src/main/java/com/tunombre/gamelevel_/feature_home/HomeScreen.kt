package com.tunombre.gamelevel_.feature_home

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

@Composable
fun HomeScreen() {
    Scaffold { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen superior (usa drawable/logo.png)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la app",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(Modifier.height(16.dp))

            // Título y subtítulo
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Game Level",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Inicia sesión o regístrate para continuar",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(24.dp))

            // Botones de inicio de sesión
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { /* TODO: login con correo */ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    contentPadding = PaddingValues(vertical = 14.dp, horizontal = 16.dp)
                ) {
                    Icon(Icons.Filled.Email, contentDescription = "Correo")
                    Spacer(Modifier.width(8.dp))
                    Text("Iniciar sesión con correo")
                }
                OutlinedButton(
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

            Spacer(Modifier.height(24.dp))

            // Separador
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(Modifier.weight(1f))
                Text(
                    "  o regístrate con  ",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
                Divider(Modifier.weight(1f))
            }

            // Empuja los iconos hacia abajo
            Spacer(modifier = Modifier.weight(1f))

            // Botones redondos de registro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedButton(
                    onClick = { /* TODO: Google */ },
                    shape = CircleShape,
                    contentPadding = PaddingValues(20.dp)
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

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    GameLevel_Theme { HomeScreen() }
}
