package com.tunombre.gamelevel_.feature_auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tunombre.gamelevel_.R
import com.tunombre.gamelevel_.ui.theme.GameLevel_Theme

// --- Colores locales (ajústalos a gusto para calzar con tu mock) ---
private val PurpleBg      = Color(0xFF2C0F88) // fondo principal
private val PurpleAppBar  = Color(0xFF5A2BDA) // app bar
private val PurpleCard    = Color(0xFF3C17B3) // tarjetas/containers
private val YellowAccent  = Color(0xFFFFD000) // botón amarillo
private val FacebookBlue  = Color(0xFF1877F2) // FB
// -------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onBack: () -> Unit = {},
    onCreateAccount: () -> Unit = {},
    onGoogle: () -> Unit = {},
    onFacebook: () -> Unit = {},
    onSteam: () -> Unit = {},
    onDiscord: () -> Unit = {},
    onTwitch: () -> Unit = {},
    onTwitter: () -> Unit = {},
    onLoginWithPassword: (String) -> Unit = {},
    onMagicLink: (String) -> Unit = {}
) {
    var email by remember { mutableStateOf("") }

    Scaffold(
        containerColor = PurpleBg,
        topBar = {
            // Barra superior morada con título centrado
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                title = {
                    Text("Sign-in", color = Color.White, fontWeight = FontWeight.SemiBold)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PurpleAppBar
                )
            )
        },
        bottomBar = {
            // Bottom bar con 4 ítems
            NavigationBar(containerColor = PurpleAppBar) {
                NavigationBarItem(
                    selected = false, onClick = { /* TODO marketplace */ },
                    icon = { Icon(Icons.Default.Store, contentDescription = null) },
                    label = { Text("Catalogo") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = PurpleCard, selectedIconColor = Color.White, selectedTextColor = Color.White)
                )
                NavigationBarItem(
                    selected = false, onClick = { /* TODO search */ },
                    icon = { Icon(Icons.Default.Search, contentDescription = null) },
                    label = { Text("Buscar") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = PurpleCard, selectedIconColor = Color.White, selectedTextColor = Color.White)
                )
                NavigationBarItem(
                    selected = false, onClick = { /* TODO cart */ },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                    label = { Text("Carrito") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = PurpleCard, selectedIconColor = Color.White, selectedTextColor = Color.White)
                )
                NavigationBarItem(
                    selected = true, onClick = { /* TODO account */ },
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                    label = { Text("My cuenta") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = PurpleCard, selectedIconColor = Color.White, selectedTextColor = Color.White)
                )
            }
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .background(PurpleBg)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // “New user? Create account”
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Nuevo Usuario? ", color = Color.White)
                TextButton(onClick = onCreateAccount) {
                    Text("Crear cuenta", color = YellowAccent, fontWeight = FontWeight.SemiBold)
                }
            }

            Spacer(Modifier.height(12.dp))

            // Botón grande Google (blanco, texto negro)
            Button(
                onClick = onGoogle,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                // Reemplaza por tu ícono oficial de Google cuando lo importes
                Icon(Icons.Default.Public, contentDescription = "G")
                Spacer(Modifier.width(12.dp))
                Text("Continuar con Google", fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(12.dp))

            // Botón grande Facebook (azul)
            Button(
                onClick = onFacebook,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = FacebookBlue,
                    contentColor = Color.White
                )
            ) {
                Icon(Icons.Default.ThumbUp, contentDescription = "Facebook") // reemplaza por ícono FB
                Spacer(Modifier.width(12.dp))
                Text("Continuar con  Facebook", fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(12.dp))

            // Tarjeta con 4 redes (Steam/Discord/Twitch/Twitter)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = PurpleCard)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onSteam, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.Default.SportsEsports, contentDescription = "Steam", tint = Color.White)
                    }
                    IconButton(onClick = onDiscord, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.Default.Forum, contentDescription = "Discord", tint = Color.White)
                    }
                    IconButton(onClick = onTwitch, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.Default.LiveTv, contentDescription = "Twitch", tint = Color.White)
                    }
                    IconButton(onClick = onTwitter, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.Default.Public, contentDescription = "Twitter", tint = Color.White)
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            // Separador "or"
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Color.White.copy(alpha = 0.25f)
                )
                Text("  or  ", color = Color.White.copy(alpha = 0.7f))
                Divider(
                    modifier = Modifier.weight(1f),
                    color = Color.White.copy(alpha = 0.25f)
                )
            }

            Spacer(Modifier.height(8.dp))

            // Label Email
            Text("Email", color = Color.White, modifier = Modifier.fillMaxWidth())

            // Campo de email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White.copy(alpha = 0.35f),
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White,
                    cursorColor = Color.White
                )
            )

            Spacer(Modifier.height(24.dp))

            // Botón amarillo “Login with password”
            Button(
                onClick = { onLoginWithPassword(email) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = YellowAccent,
                    contentColor = Color(0xFF101010)
                ),
                enabled = email.isNotBlank()
            ) {
                Text("Login with password", fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(12.dp))

            // Botón “Login with magic link” (outlined)
            OutlinedButton(
                onClick = { onMagicLink(email) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp),
                enabled = email.isNotBlank()
            ) {
                Text("Login with magic link", fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignInPreview() {
    GameLevel_Theme {
        SignInScreen()
    }
}
