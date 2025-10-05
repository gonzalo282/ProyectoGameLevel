package com.tunombre.gamelevel_.feature_account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tunombre.gamelevel_.ui.theme.*

// Acento turquesa para el monto grande
private val Aqua = Color(0xFF00D1B2)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    navController: NavController, // <--- PARÁMETRO AÑADIDO
    // datos
    email: String = "ghon.cbr@gmail.com",
    nick: String  = "Game Level id:01",

    // callbacks
    onTopUp: () -> Unit = {},
    onLearnMore: () -> Unit = {},

    // acciones
    onConnectedApps: () -> Unit = {},
    onMfa: () -> Unit = {},
    onTickets: () -> Unit = {},
    onAppPreferences: () -> Unit = {},
) {

    Scaffold(
        containerColor = PurpleBg,
        topBar = {
            TopAppBar(
                title = { Text("Mi Cuenta", color = OnDark, fontWeight = FontWeight.SemiBold) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PurpleAppBar)
            )
        },
        bottomBar = {
            NavigationBar(containerColor = PurpleAppBar) {
                // CONECTAMOS LAS ACCIONES AL NAVCONTROLLER
                NavigationBarItem(
                    selected = false, onClick = { navController.navigate("catalog") },
                    icon = { Icon(Icons.Default.Store, null) }, label = { Text("Marketplace") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent, unselectedIconColor = OnMuted, unselectedTextColor = OnMuted)
                )
                NavigationBarItem(
                    selected = false, onClick = { /* navController.navigate("search") */ },
                    icon = { Icon(Icons.Default.Search, null) }, label = { Text("Search") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent, unselectedIconColor = OnMuted, unselectedTextColor = OnMuted)
                )
                NavigationBarItem(
                    selected = false, onClick = { navController.navigate("cart") },
                    icon = { Icon(Icons.Default.ShoppingCart, null) }, label = { Text("Cart") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent, unselectedIconColor = OnMuted, unselectedTextColor = OnMuted)
                )
                NavigationBarItem(
                    selected = true, onClick = { /* Ya estamos aquí */ },
                    icon = { Icon(Icons.Default.AccountCircle, null) }, label = { Text("My account") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent, selectedIconColor = OnDark, selectedTextColor = OnDark)
                )
            }
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // ---------- Header con avatar + email ----------
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(PurpleCard),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.SmartToy, contentDescription = null, tint = YellowAccent)
                }
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text(email, color = OnDark, fontWeight = FontWeight.SemiBold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Text(nick, color = OnMuted, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                IconButton(onClick = { /* opciones */ }) {
                    Icon(Icons.Default.MoreVert, contentDescription = null, tint = OnDark)
                }
            }

            // ---------- Card: balance + botón Top-up ----------
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = PurpleCard),
                border = BorderStroke(1.dp, BorderSoft)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Dinero Disponible", color = OnDark, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(8.dp))
                    Text("$0", color = Aqua, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.ExtraBold)
                    Spacer(Modifier.height(12.dp))
                    FilledTonalButton(
                        onClick = onTopUp,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.filledTonalButtonColors(containerColor = PurpleBg, contentColor = OnDark)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Top-up", fontWeight = FontWeight.SemiBold)
                            Icon(Icons.Default.ChevronRight, contentDescription = null)
                        }
                    }
                }
            }

            // ---------- Card: progreso de perfil ----------
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = PurpleCard),
                border = BorderStroke(1.dp, BorderSoft)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Datos Completados", color = OnDark, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { 0.33f },
                        trackColor = PurpleBg,
                        color = YellowAccent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .clip(RoundedCornerShape(6.dp))
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Registro Completo", color = OnMuted)
                        Icon(Icons.Default.ChevronRight, contentDescription = null, tint = OnMuted)
                    }
                }
            }

            // ---------- Card: Club ----------
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = PurpleCard),
                border = BorderStroke(1.dp, BorderSoft)
            ) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Game Level", color = OnDark, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("Junta Puntos Game Level y Disfruta De Descuentos", color = OnMuted)
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Button(
                            onClick = { navController.navigate("signin") },  // <- vuelve al login
                            colors = ButtonDefaults.buttonColors(containerColor = YellowAccent, contentColor = BgBlack),
                            shape = RoundedCornerShape(12.dp),
                        ) { Text("Join now", fontWeight = FontWeight.Bold) }

                        OutlinedButton(
                            onClick = onLearnMore,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = OnDark),
                            border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp),
                            shape = RoundedCornerShape(12.dp),
                        ) { Text("Learn more", fontWeight = FontWeight.SemiBold) }
                    }
                }
            }

            // ... El resto del código para la lista de acciones y logout se mantiene igual ...
            // ---------- Lista de acciones ----------
            SectionTitle("Seguridad")
            ListItemRow("Connecta tus apps", Icons.Default.Link, onClick = onConnectedApps)
            ListItemRow("Multi factor autentificacion", Icons.Default.Lock, onClick = onMfa)
            ListItemRow("Support / Tickets", Icons.Default.SupportAgent, onClick = onTickets)

            SectionTitle("Settings")
            ListItemRow("App preferencias", Icons.Default.Settings, onClick = onAppPreferences)

            // ---------- Logout ----------
            Spacer(Modifier.height(8.dp))
            TextButton(
                onClick = {
                    // Lógica para desloguear y volver a signin limpiando el historial
                    navController.navigate("signin") {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) { Text("Logout", color = YellowAccent, fontWeight = FontWeight.Bold) }

            Spacer(Modifier.height(12.dp))
        }
    }
}

// ... (El resto de tus Composables privados como SectionTitle y ListItemRow se mantienen igual)
@Composable
private fun SectionTitle(text: String) {
    Text(text, color = OnMuted, modifier = Modifier.padding(top = 8.dp))
}

@Composable
private fun ListItemRow(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = PurpleCard,
        border = BorderStroke(1.dp, BorderSoft),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = OnDark)
            Spacer(Modifier.width(12.dp))
            Text(title, color = OnDark, modifier = Modifier.weight(1f))
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = OnMuted)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun AccountPreview() {
    // Para que el preview funcione, creamos un NavController falso.
    val navController = NavController(androidx.compose.ui.platform.LocalContext.current)
    GameLevel_Theme { AccountScreen(navController = navController) }
}