package com.tunombre.gamelevel_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tunombre.gamelevel_.feature_account.AccountScreen
import com.tunombre.gamelevel_.feature_auth.SignInScreen
import com.tunombre.gamelevel_.feature_cart.CartScreen
import com.tunombre.gamelevel_.feature_catalog.CatalogScreen
import com.tunombre.gamelevel_.ui.composables.AppBottomBar
import com.tunombre.gamelevel_.ui.theme.GameLevel_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GameLevel_Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "signin"
    ) {
        // Pantalla de SignIn
        composable("signin") {
            SignInScreen(
                onBack = { /* navController.popBackStack() si quieres */ },
                onCreateAccount = { /* TODO: ir a registro */ },

                // Ahora todas las acciones llevan a la pantalla de Catálogo
                onGoogle = { navController.navigate("catalog") },
                onFacebook = { navController.navigate("catalog") },
                onSteam = { navController.navigate("catalog") },
                onDiscord = { navController.navigate("catalog") },
                onTwitch = { navController.navigate("catalog") },
                onTwitter = { navController.navigate("catalog") },

                onLoginWithPassword = { _ -> navController.navigate("catalog") },
                onMagicLink = { _ -> navController.navigate("catalog") }
            )
        }

        // Pantalla de Cuenta
        composable("account") {
            AccountScreen(
                // Pasamos el navController para que pueda navegar
                navController = navController
            )
        }

        // Pantalla del Catálogo
        composable("catalog") {
            CatalogScreen(navController = navController)
        }

        // Pantalla del Carrito
        composable("cart") {
            CartScreen(navController = navController)
        }
    }
}